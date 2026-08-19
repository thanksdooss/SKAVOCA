package com.skavoca.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubmitAnswerResponse {
    private String resultType; // CORRECT, INCORRECT, TYPO_WARNING
    private boolean isCorrect;
    private boolean isTypo;
    private Double similarity;
    private String correctTerm;
    private Integer earnedXp;
    private Long currentTotalXp;
    private Integer inferredQuality;
    private AlgorithmMetrics algorithmMetrics;
    private Feedback feedback;
    private String audioUrl;
    private String message;
    private boolean allowRetry;

    @Data
    @Builder
    public static class AlgorithmMetrics {
        private Double oldEf;
        private Double newEf;
        private Integer oldInterval;
        private Integer newInterval;
        private Integer repetitions;
    }

    @Data
    @Builder
    public static class Feedback {
        private String conceptDiff;
        private String definition;
        private String practicalTip;
    }
}
