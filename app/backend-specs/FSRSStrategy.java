package com.skala.skavoca.algorithm;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * Free Spaced Repetition Scheduler (FSRS) Strategy (OCP Extension Example)
 * Ready for hot-swapping when user review history exceeds 1,000 logs.
 */
@Component("fsrsStrategy")
public class FSRSStrategy implements SpacedRepetitionStrategy {

    @Override
    public AlgorithmResult calculateNextReview(AlgorithmInput input) {
        // FSRS DSR (Difficulty, Stability, Retrievability) vector computation stub
        int nextInterval = (int) Math.round(input.intervalDays() * 2.2);
        return new AlgorithmResult(
            input.repetitions() + 1,
            input.easinessFactor(),
            Math.max(1, nextInterval),
            LocalDateTime.now().plusDays(nextInterval),
            input.totalReviews() + 1,
            input.totalLapses()
        );
    }
}
