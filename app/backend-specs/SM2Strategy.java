package com.skala.skavoca.algorithm;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * SuperMemo-2 (SM-2) Implementation with Anki-style Fuzzing
 */
@Component("sm2Strategy")
public class SM2Strategy implements SpacedRepetitionStrategy {

    private static final double MIN_EASINESS_FACTOR = 1.3;

    @Override
    public AlgorithmResult calculateNextReview(AlgorithmInput input) {
        int q = Math.max(0, Math.min(5, input.qualityScore()));
        int totalReviews = input.totalReviews() + 1;
        int totalLapses = input.totalLapses();

        // 1. Calculate New Easiness Factor (EF)
        // EF' = EF + (0.1 - (5 - q) * (0.08 + (5 - q) * 0.02))
        double newEf = input.easinessFactor() + (0.1 - (5 - q) * (0.08 + (5 - q) * 0.02));
        newEf = Math.max(MIN_EASINESS_FACTOR, Math.round(newEf * 100.0) / 100.0);

        int newInterval;
        int newRepetitions;

        // 2. Interval & Repetitions Calculation
        if (q < 3) {
            // Failure / Again
            newRepetitions = 0;
            newInterval = 1;
            totalLapses += 1;
        } else {
            // Success (q >= 3)
            if (input.repetitions() == 0) {
                newInterval = 1;
            } else if (input.repetitions() == 1) {
                newInterval = 6;
            } else {
                newInterval = (int) Math.round(input.intervalDays() * newEf);
            }
            newInterval = applyAnkiFuzzing(newInterval);
            newRepetitions = input.repetitions() + 1;
        }

        LocalDateTime nextPracticeDate = LocalDateTime.now().plusDays(newInterval);

        return new AlgorithmResult(
            newRepetitions,
            newEf,
            newInterval,
            nextPracticeDate,
            totalReviews,
            totalLapses
        );
    }

    /**
     * Anki Fuzzing Jitter: +/- 10% on intervals >= 3 days to balance daily load
     */
    private int applyAnkiFuzzing(int intervalDays) {
        if (intervalDays < 3) return intervalDays;
        int fuzzRange = Math.max(1, (int) Math.round(intervalDays * 0.1));
        int fuzz = ThreadLocalRandom.current().nextInt(-fuzzRange, fuzzRange + 1);
        return Math.max(1, intervalDays + fuzz);
    }
}
