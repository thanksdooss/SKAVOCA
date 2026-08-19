package com.skavoca.service;

import com.skavoca.dto.SubmitAnswerRequest;
import com.skavoca.dto.SubmitAnswerResponse;
import com.skavoca.dto.TodayDeckResponse;
import com.skavoca.dto.WordDto;
import com.skavoca.entity.ReviewLog;
import com.skavoca.entity.User;
import com.skavoca.entity.UserProgress;
import com.skavoca.entity.Word;
import com.skavoca.repository.ReviewLogRepository;
import com.skavoca.repository.UserProgressRepository;
import com.skavoca.repository.UserRepository;
import com.skavoca.repository.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LearningService {

    private final UserProgressRepository progressRepository;
    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final ReviewLogRepository logRepository;
    private final Sm2Engine sm2Engine;
    private final LevenshteinService levenshteinService;
    private final GamificationService gamificationService;
    private final AiFeedbackService aiFeedbackService;

    public LearningService(UserProgressRepository progressRepository, WordRepository wordRepository, 
                           UserRepository userRepository, ReviewLogRepository logRepository, 
                           Sm2Engine sm2Engine, LevenshteinService levenshteinService,
                           GamificationService gamificationService, AiFeedbackService aiFeedbackService) {
        this.progressRepository = progressRepository;
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.logRepository = logRepository;
        this.sm2Engine = sm2Engine;
        this.levenshteinService = levenshteinService;
        this.gamificationService = gamificationService;
        this.aiFeedbackService = aiFeedbackService;
    }

    public TodayDeckResponse getTodayDeck(Long userId) {
        LocalDateTime now = LocalDateTime.now();
        List<UserProgress> dueProgress = progressRepository.findByUser_UserIdAndNextPracticeDateLessThanEqual(userId, now);
        
        List<WordDto> reviewWords = dueProgress.stream().map(p -> mapToDto(p.getWord())).collect(Collectors.toList());
        
        // Mock new words (all words not in progress)
        List<Long> progressedWordIds = progressRepository.findAllByUser_UserId(userId).stream()
            .map(p -> p.getWord().getWordId()).collect(Collectors.toList());
            
        List<Word> allWords = wordRepository.findAll();
        List<WordDto> newWords = allWords.stream()
            .filter(w -> !progressedWordIds.contains(w.getWordId()))
            .limit(5)
            .map(this::mapToDto)
            .collect(Collectors.toList());
            
        return new TodayDeckResponse(reviewWords, newWords, reviewWords.size() + newWords.size());
    }

    public SubmitAnswerResponse submitAnswer(Long userId, SubmitAnswerRequest request) {
        if (request.getLocalLogId() != null && !request.getLocalLogId().isEmpty()) {
            java.util.Optional<ReviewLog> existing = logRepository.findByLocalLogId(request.getLocalLogId());
            if (existing.isPresent()) {
                return buildResponseFromExistingLog(existing.get());
            }
        }
        
        User user = userRepository.findById(userId).orElseThrow();
        Word word = wordRepository.findById(request.getWordId()).orElseThrow();
        
        String normalizedInput = levenshteinService.normalizeCanonical(request.getUserInput());
        String normalizedAnswer = levenshteinService.normalizeCanonical(word.getTerm());
        
        // AFK 보정: 60초 초과 시 최대 60초로 클램핑
        double clampedTimeSec = Math.min(request.getResponseTimeSec(), 60.0);
        
        boolean isExactMatch = normalizedInput.equals(normalizedAnswer);
        double similarity = levenshteinService.calculateSimilarity(normalizedInput, normalizedAnswer);
        
        String resultType;
        boolean isCorrect = false;
        boolean isTypo = false;
        boolean isConfusion = false;
        boolean allowRetry = false;
        String confusedWith = null;
        
        if (isExactMatch) {
            resultType = "CORRECT";
            isCorrect = true;
        } else {
            // 혼동 오답 검사: 입력값이 다른 IT 용어와 일치하는지 확인 (war→jar 등)
            Word confusedWord = wordRepository.findByTermIgnoreCase(request.getUserInput().trim());
            if (confusedWord != null && !confusedWord.getWordId().equals(word.getWordId())) {
                resultType = "INCORRECT";
                isConfusion = true;
                confusedWith = confusedWord.getTerm();
            } else if (levenshteinService.isTypoForgiven(normalizedInput, normalizedAnswer)) {
                resultType = "TYPO_WARNING";
                isTypo = true;
                allowRetry = true;
            } else {
                resultType = "INCORRECT";
            }
        }
        
        if (allowRetry) {
            return SubmitAnswerResponse.builder()
                .resultType(resultType)
                .isCorrect(false)
                .isTypo(true)
                .similarity(similarity)
                .correctTerm(word.getTerm())
                .message("Typo detected, please try again.")
                .allowRetry(true)
                .build();
        }
        
        int quality = sm2Engine.inferQualityScore(isCorrect, clampedTimeSec, request.getHintCount(), request.getTypoCount());
        
        UserProgress progress = progressRepository.findByUser_UserIdAndWord_WordId(userId, word.getWordId())
            .orElseGet(() -> UserProgress.builder()
                .user(user)
                .word(word)
                .repetitions(0)
                .intervalDays(1)
                .easinessFactor(2.5)
                .totalReviews(0)
                .totalLapses(0)
                .build());
                
        double oldEf = progress.getEasinessFactor();
        int oldInterval = progress.getIntervalDays();
        
        LocalDateTime reviewTime = LocalDateTime.now();
        if (request.getStudiedAt() != null) {
            LocalDateTime studiedAt = request.getStudiedAt();
            LocalDateTime now = LocalDateTime.now();
            if (studiedAt.isBefore(now.minusHours(48)) || studiedAt.isAfter(now.plusHours(48))) {
                reviewTime = now;
            } else {
                reviewTime = studiedAt;
            }
        }

        boolean alreadyEarnedXpToday = logRepository.existsByUser_UserIdAndWord_WordIdAndReviewedAtAfter(
            userId, word.getWordId(), reviewTime.toLocalDate().atStartOfDay()
        );

        if (isCorrect) {
            progress.setEasinessFactor(sm2Engine.calculateNewEf(oldEf, quality));
            progress.setRepetitions(progress.getRepetitions() + 1);
            progress.setIntervalDays(sm2Engine.calculateNextInterval(progress.getRepetitions(), progress.getEasinessFactor()));
            if (!alreadyEarnedXpToday) {
                gamificationService.awardXp(userId, 10);
            }
        } else {
            progress.setEasinessFactor(Math.max(1.3, oldEf - 0.2));
            progress.setRepetitions(0);
            progress.setIntervalDays(1);
            progress.setTotalLapses(progress.getTotalLapses() + 1);
        }
        
        progress.setTotalReviews(progress.getTotalReviews() + 1);
        progress.setLastReviewedAt(reviewTime);
        progress.setNextPracticeDate(reviewTime.plusDays(progress.getIntervalDays()));
        progressRepository.save(progress);
        
        ReviewLog log = ReviewLog.builder()
            .localLogId(request.getLocalLogId())
            .user(user)
            .word(word)
            .inferredQuality(quality)
            .responseTimeSec(request.getResponseTimeSec())
            .hintCount(request.getHintCount())
            .typoCount(request.getTypoCount())
            .calculatedEf(progress.getEasinessFactor())
            .reviewInterval(progress.getIntervalDays())
            .reviewedAt(reviewTime)
            .build();
        logRepository.save(log);
        
        SubmitAnswerResponse.Feedback feedback = null;
        if (!isCorrect) {
            feedback = aiFeedbackService.getDistractorFeedback(word.getWordId(), request.getUserInput());
        }

        int earnedXp = (isCorrect && !alreadyEarnedXpToday) ? 10 : 0;

        return SubmitAnswerResponse.builder()
            .resultType(resultType)
            .isCorrect(isCorrect)
            .isTypo(isTypo)
            .similarity(similarity)
            .correctTerm(word.getTerm())
            .earnedXp(earnedXp)
            .currentTotalXp(user.getXp() + earnedXp)
            .inferredQuality(quality)
            .algorithmMetrics(SubmitAnswerResponse.AlgorithmMetrics.builder()
                .oldEf(oldEf)
                .newEf(progress.getEasinessFactor())
                .oldInterval(oldInterval)
                .newInterval(progress.getIntervalDays())
                .repetitions(progress.getRepetitions())
                .build())
            .feedback(feedback)
            .message(isCorrect ? "Correct!" : "Incorrect!")
            .allowRetry(false)
            .build();
    }
    
    public com.skavoca.dto.SyncBatchResponse syncBatch(Long userId, com.skavoca.dto.SyncBatchRequest request) {
        List<SubmitAnswerResponse> results = new ArrayList<>();
        int success = 0;
        int fail = 0;
        if (request.getItems() != null) {
            for (SubmitAnswerRequest item : request.getItems()) {
                try {
                    SubmitAnswerResponse res = submitAnswer(userId, item);
                    results.add(res);
                    success++;
                } catch (Exception e) {
                    fail++;
                }
            }
        }
        return new com.skavoca.dto.SyncBatchResponse(results, success, fail);
    }

    
    private SubmitAnswerResponse buildResponseFromExistingLog(ReviewLog log) {
        return SubmitAnswerResponse.builder()
            .resultType(log.getIsCorrect() ? "CORRECT" : "INCORRECT")
            .isCorrect(log.getIsCorrect())
            .isTypo(log.getTypoCount() != null && log.getTypoCount() > 0)
            .similarity(1.0)
            .correctTerm(log.getWord().getTerm())
            .earnedXp(log.getXpEarned())
            .currentTotalXp(log.getUser().getXp())
            .inferredQuality(log.getInferredQuality())
            .algorithmMetrics(SubmitAnswerResponse.AlgorithmMetrics.builder()
                .oldEf(0.0)
                .newEf(log.getCalculatedEf())
                .oldInterval(0)
                .newInterval(log.getReviewInterval())
                .repetitions(0)
                .build())
            .message("Cached result")
            .allowRetry(false)
            .build();
    }

    private WordDto mapToDto(Word word) {
        return WordDto.builder()
            .wordId(word.getWordId())
            .courseId(word.getCourse().getCourseId())
            .courseName(word.getCourse().getCourseName())
            .term(word.getTerm())
            .fullTerm(word.getFullTerm())
            .pronunciationKr(word.getPronunciationKr())
            .pronunciationSsml(word.getPronunciationSsml())
            .easyMeaning(word.getEasyMeaning())
            .contextSentence(word.getContextSentence())
            .difficulty(word.getDifficulty())
            .distractors(new ArrayList<>())
            .build();
    }
}
