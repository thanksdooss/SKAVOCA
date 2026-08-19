package com.skala.skavoca.algorithm;

import java.time.LocalDateTime;

/**
 * Spaced Repetition Strategy Interface (Strategy Pattern)
 * Follows Open-Closed Principle (OCP) allowing seamless hot-swap between SM-2 and FSRS.
 */
public interface SpacedRepetitionStrategy {
    AlgorithmResult calculateNextReview(AlgorithmInput input);

    record AlgorithmInput(
        int repetitions,
        double easinessFactor,
        int intervalDays,
        int qualityScore, // 0~5
        int totalReviews,
        int totalLapses
    ) {}

    record AlgorithmResult(
        int newRepetitions,
        double newEasinessFactor,
        int newIntervalDays,
        LocalDateTime nextPracticeDate,
        int totalReviews,
        int totalLapses
    ) {}
}
