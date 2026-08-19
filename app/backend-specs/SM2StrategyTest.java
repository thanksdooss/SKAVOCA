package com.skala.skavoca.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TDD Unit Test Suite for SM-2 Algorithm (Benchmarking Open-Spaced-Repetition)
 */
class SM2StrategyTest {

    private final SM2Strategy strategy = new SM2Strategy();

    @Test
    @DisplayName("Quality 5 (Easy) on First Review: EF increases and Interval is 1 day")
    void testFirstReviewQuality5() {
        var input = new SpacedRepetitionStrategy.AlgorithmInput(0, 2.50, 0, 5, 0, 0);
        var result = strategy.calculateNextReview(input);

        assertEquals(1, result.newRepetitions());
        assertEquals(2.60, result.newEasinessFactor(), 0.01);
        assertEquals(1, result.newIntervalDays());
        assertEquals(1, result.totalReviews());
        assertEquals(0, result.totalLapses());
    }

    @Test
    @DisplayName("Quality 4 (Good) on Second Review: Interval becomes 6 days")
    void testSecondReviewQuality4() {
        var input = new SpacedRepetitionStrategy.AlgorithmInput(1, 2.60, 1, 4, 1, 0);
        var result = strategy.calculateNextReview(input);

        assertEquals(2, result.newRepetitions());
        assertEquals(2.60, result.newEasinessFactor(), 0.01);
        assertTrue(result.newIntervalDays() >= 5 && result.newIntervalDays() <= 7); // With Anki Fuzzing
    }

    @Test
    @DisplayName("Quality 0 (Again/Blackout): Repetitions reset to 0 and Interval resets to 1 day")
    void testBlackoutLapse() {
        var input = new SpacedRepetitionStrategy.AlgorithmInput(3, 2.50, 15, 0, 3, 0);
        var result = strategy.calculateNextReview(input);

        assertEquals(0, result.newRepetitions());
        assertEquals(1.70, result.newEasinessFactor(), 0.01);
        assertEquals(1, result.newIntervalDays());
        assertEquals(1, result.totalLapses());
    }

    @Test
    @DisplayName("EF Floor Limit: Easiness Factor should never drop below 1.30")
    void testMinimumEfBoundary() {
        var input = new SpacedRepetitionStrategy.AlgorithmInput(0, 1.35, 1, 0, 5, 4);
        var result = strategy.calculateNextReview(input);

        assertEquals(1.30, result.newEasinessFactor(), 0.001);
    }
}
