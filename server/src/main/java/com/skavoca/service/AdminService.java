package com.skavoca.service;

import com.skavoca.dto.DifficultWordDto;
import com.skavoca.dto.WordCreateRequest;
import com.skavoca.entity.CurriculumCourse;
import com.skavoca.entity.Word;
import com.skavoca.repository.CurriculumCourseRepository;
import com.skavoca.repository.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class AdminService {

    private final WordRepository wordRepository;
    private final CurriculumCourseRepository courseRepository;
    private final com.skavoca.repository.UserProgressRepository progressRepository;

    public AdminService(WordRepository wordRepository, CurriculumCourseRepository courseRepository, com.skavoca.repository.UserProgressRepository progressRepository) {
        this.wordRepository = wordRepository;
        this.courseRepository = courseRepository;
        this.progressRepository = progressRepository;
    }

    public List<DifficultWordDto> getDifficultWords(Integer cohort, Integer limit) {
        return progressRepository.findDifficultWords(cohort, org.springframework.data.domain.PageRequest.of(0, limit));
    }

    public void createWord(WordCreateRequest request) {
        CurriculumCourse course = courseRepository.findById(request.getCourseId())
            .orElseThrow(() -> new RuntimeException("Course not found"));
            
        Word word = Word.builder()
            .course(course)
            .term(request.getTerm())
            .fullTerm(request.getFullTerm())
            .pronunciationKr(request.getPronunciationKr())
            .pronunciationSsml(request.getPronunciationSsml())
            .easyMeaning(request.getEasyMeaning())
            .contextSentence(request.getContextSentence())
            .difficulty(request.getDifficulty() != null ? request.getDifficulty() : "MEDIUM")
            .build();
            
        wordRepository.save(word);
    }

    public com.skavoca.dto.BulkUploadResponse bulkUploadWords(List<WordCreateRequest> requests) {
        int created = 0;
        int failed = 0;
        for (WordCreateRequest req : requests) {
            try {
                createWord(req);
                created++;
            } catch (Exception e) {
                failed++;
            }
        }
        return new com.skavoca.dto.BulkUploadResponse(created, failed);
    }

    public void updateWord(Long wordId, WordCreateRequest request) {
        Word word = wordRepository.findById(wordId)
            .orElseThrow(() -> new RuntimeException("Word not found"));
        CurriculumCourse course = courseRepository.findById(request.getCourseId())
            .orElseThrow(() -> new RuntimeException("Course not found"));
            
        word.setCourse(course);
        word.setTerm(request.getTerm());
        word.setFullTerm(request.getFullTerm());
        word.setPronunciationKr(request.getPronunciationKr());
        word.setPronunciationSsml(request.getPronunciationSsml());
        word.setEasyMeaning(request.getEasyMeaning());
        word.setContextSentence(request.getContextSentence());
        word.setDifficulty(request.getDifficulty() != null ? request.getDifficulty() : "MEDIUM");
        wordRepository.save(word);
    }

    public void deleteWord(Long wordId) {
        Word word = wordRepository.findById(wordId)
            .orElseThrow(() -> new RuntimeException("Word not found"));
        word.setIsActive(false);
        word.setDeletedAt(java.time.LocalDateTime.now());
        wordRepository.save(word);
    }
}
