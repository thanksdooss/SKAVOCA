package com.skavoca.dto;

import lombok.Builder;
import java.util.List;

@Builder
public record MyStatsResponse(
    int totalWordsLearned,
    int totalReviews,
    double averageAccuracy,
    int streakDays,
    int weeklyXp,
    List<CourseStat> courseStats
) {
    @Builder
    public record CourseStat(
        Integer courseId,
        String courseName,
        int wordsLearned,
        double avgEf
    ) {}
}
