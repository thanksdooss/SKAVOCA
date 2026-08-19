package com.skavoca.service;

import com.skavoca.dto.SubmitAnswerResponse.Feedback;
import com.skavoca.entity.ConfusingDistractor;
import com.skavoca.entity.Word;
import com.skavoca.repository.ConfusingDistractorRepository;
import com.skavoca.repository.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AiFeedbackService {

    private static final String SECTION_DELIMITER = "\n---\n";

    private final ConfusingDistractorRepository distractorRepository;
    private final WordRepository wordRepository;

    public AiFeedbackService(ConfusingDistractorRepository distractorRepository, WordRepository wordRepository) {
        this.distractorRepository = distractorRepository;
        this.wordRepository = wordRepository;
    }

    public Feedback getDistractorFeedback(Long wordId, String wrongInput) {
        // 1. DB에 시딩된 피드백이 있는지 확인
        return distractorRepository.findByWord_WordIdAndWrongInput(wordId, wrongInput)
            .map(d -> parseFeedback(d, wordId))
            .orElseGet(() -> generateTemplateFeedback(wordId));
    }

    /**
     * 단어 데이터(정의 + 예문)를 기반으로 피드백을 생성합니다.
     */
    private Feedback generateTemplateFeedback(Long wordId) {
        Word word = wordRepository.findById(wordId)
            .orElseThrow(() -> new RuntimeException("Word not found: " + wordId));

        String definition = word.getTerm() + " : " +
            (word.getEasyMeaning() != null ? word.getEasyMeaning() : "해당 개념의 정의를 확인해 주세요.");

        String contextSentence = word.getContextSentence() != null
            ? word.getContextSentence().replaceAll("\\{\\{", "").replaceAll("\\}\\}", "")
            : word.getTerm() + "의 의미와 사용 맥락을 반복 학습해 보세요.";

        return Feedback.builder()
            .conceptDiff("")
            .definition(definition)
            .practicalTip(contextSentence)
            .build();
    }

    /**
     * DB에서 가져온 기존 피드백을 파싱합니다.
     */
    private Feedback parseFeedback(ConfusingDistractor distractor, Long wordId) {
        String explanation = distractor.getFeedbackExplanation();

        if (explanation != null && explanation.contains(SECTION_DELIMITER)) {
            String[] parts = explanation.split(SECTION_DELIMITER);
            return Feedback.builder()
                .conceptDiff(parts.length > 0 ? parts[0].trim() : "")
                .definition(parts.length > 1 ? parts[1].trim() : "")
                .practicalTip(parts.length > 2 ? parts[2].trim() : "")
                .build();
        }

        // 레거시 단일 문자열 (seed_data.sql에서 시딩된 한국어 해설)
        Word word = wordRepository.findById(wordId).orElse(null);
        String definition = word != null
            ? word.getTerm() + " : " + word.getEasyMeaning()
            : "정답 개념을 다시 확인해 보세요.";

        String contextSentence = word != null && word.getContextSentence() != null
            ? word.getContextSentence().replaceAll("\\{\\{", "").replaceAll("\\}\\}", "")
            : "해당 단어의 예문을 반복 학습하여 문맥 속에서 익혀보세요.";

        return Feedback.builder()
            .conceptDiff(explanation != null ? explanation : "")
            .definition(definition)
            .practicalTip(contextSentence)
            .build();
    }
}
