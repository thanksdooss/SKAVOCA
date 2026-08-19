package com.skavoca.service;

import org.springframework.stereotype.Service;

@Service
public class Sm2Engine {

    public int inferQualityScore(boolean isCorrect, double responseTimeSec, int hintCount, int typoCount) {
        if (!isCorrect) return 0;
        if (hintCount >= 2 || responseTimeSec > 25.0) return 2;
        if (hintCount == 1 || responseTimeSec > 10.0 || typoCount >= 2) return 3;
        if (responseTimeSec >= 4.0 && responseTimeSec <= 10.0) return 4;
        return 5;
    }

    public double calculateNewEf(double oldEf, int quality) {
        double newEf = oldEf + (0.1 - (5 - quality) * (0.08 + (5 - quality) * 0.02));
        return Math.max(1.3, newEf);
    }

    public int calculateNextInterval(int repetitions, double newEf) {
        if (repetitions == 0) return 1;
        if (repetitions == 1) return 6;
        int interval = (int) Math.round(6 * newEf); // simplified for later reps. Strictly SM-2: I(n) = I(n-1) * EF
        return applyAnkiFuzzing(interval);
    }

    public int applyAnkiFuzzing(int intervalDays) {
        if (intervalDays < 3) return intervalDays;
        int fuzz = (int) Math.round(intervalDays * 0.1);
        int fuzzed = intervalDays + (int) (Math.random() * (2 * fuzz + 1)) - fuzz;
        return Math.max(1, fuzzed);
    }
}
