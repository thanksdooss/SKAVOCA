// SuperMemo-2 (SM-2) Spaced Repetition Engine with Anki Fuzzing & Implicit Telemetry Assessment

/**
 * Anki Fuzzing Factor: adds +/- 10% random jitter to intervals >= 3 days
 * to prevent bunching of review cards on the same day.
 */
function applyAnkiFuzzing(intervalDays) {
  if (intervalDays < 3) return intervalDays;
  const fuzzRange = Math.max(1, Math.round(intervalDays * 0.1));
  const randomFuzz = Math.floor(Math.random() * (fuzzRange * 2 + 1)) - fuzzRange;
  return Math.max(1, intervalDays + randomFuzz);
}

/**
 * Implicit Assessment: automatically infers SM-2 Quality Score (0~5) from user telemetry
 */
export function inferQualityScore(isCorrect, responseTimeSec, hintCount, typoCount) {
  if (!isCorrect) {
    return 0; // Again (Complete blackout / incorrect)
  }

  // Used 2+ hints or took over 20s
  if (hintCount >= 2 || responseTimeSec > 20.0) {
    return 2; // Blackout remembered after massive struggle
  }

  // Used 1 hint or took 10~20s or had multiple typos
  if (hintCount === 1 || responseTimeSec > 10.0 || typoCount >= 2) {
    return 3; // Hard (Serious difficulty)
  }

  // No hints, answered within 4~10s
  if (responseTimeSec >= 4.0 && responseTimeSec <= 10.0) {
    return 4; // Good (Ideal recall hesitation)
  }

  // Fast response (< 4s) with zero hints (Perfect instant recall)
  return 5; // Easy (Perfect response)
}

/**
 * SM-2 Calculation Strategy
 */
export class SM2Strategy {
  calculateNextReview(currentProgress, qualityScore) {
    const q = Math.max(0, Math.min(5, qualityScore));
    let {
      repetitions = 0,
      easinessFactor = 2.5,
      intervalDays = 0,
      totalReviews = 0,
      totalLapses = 0
    } = currentProgress || {};

    totalReviews += 1;

    // 1. Calculate New Easiness Factor (EF)
    // EF' = EF + (0.1 - (5 - q) * (0.08 + (5 - q) * 0.02))
    let newEf = easinessFactor + (0.1 - (5 - q) * (0.08 + (5 - q) * 0.02));
    newEf = Math.max(1.3, Number(newEf.toFixed(2)));

    let newInterval = 1;
    let newRepetitions = repetitions;

    // 2. Interval Scheduling
    if (q < 3) {
      // Failure / Again
      newRepetitions = 0;
      newInterval = 1;
      totalLapses += 1;
    } else {
      // Success
      if (newRepetitions === 0) {
        newInterval = 1;
      } else if (newRepetitions === 1) {
        newInterval = 6;
      } else {
        newInterval = Math.round(intervalDays * newEf);
      }
      newInterval = applyAnkiFuzzing(newInterval);
      newRepetitions += 1;
    }

    // 3. Compute Next Practice Date
    const nextDate = new Date();
    nextDate.setDate(nextDate.getDate() + newInterval);

    return {
      repetitions: newRepetitions,
      easinessFactor: newEf,
      intervalDays: newInterval,
      nextPracticeDate: nextDate.toISOString(),
      lastReviewedAt: new Date().toISOString(),
      totalReviews,
      totalLapses,
      inferredQuality: q
    };
  }
}

export const sm2Engine = new SM2Strategy();
