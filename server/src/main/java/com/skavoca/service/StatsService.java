package com.skavoca.service;

import com.skavoca.dto.MyStatsResponse;
import com.skavoca.entity.UserProgress;
import com.skavoca.repository.UserProgressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class StatsService {

    private final UserProgressRepository userProgressRepository;

    public StatsService(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }

    public MyStatsResponse getMyStats(Long userId) {
        List<UserProgress> progressList = userProgressRepository.findAllByUser_UserId(userId);
        
        int totalWordsLearned = progressList.size();
        int totalReviews = progressList.stream().mapToInt(p -> p.getTotalReviews() != null ? p.getTotalReviews() : 0).sum();
        int totalLapses = progressList.stream().mapToInt(p -> p.getTotalLapses() != null ? p.getTotalLapses() : 0).sum();
        
        double averageAccuracy = 100.0;
        if (totalReviews > 0) {
            averageAccuracy = ((double) (totalReviews - totalLapses) / totalReviews) * 100.0;
        }

        Map<Integer, List<UserProgress>> byCourse = progressList.stream()
                .collect(Collectors.groupingBy(p -> p.getWord().getCourse().getCourseId()));

        List<MyStatsResponse.CourseStat> courseStats = byCourse.entrySet().stream()
                .map(entry -> {
                    Integer courseId = entry.getKey();
                    List<UserProgress> courseProgress = entry.getValue();
                    String courseName = courseProgress.get(0).getWord().getCourse().getCourseName();
                    int wordsLearned = courseProgress.size();
                    double avgEf = courseProgress.stream()
                            .mapToDouble(p -> p.getEasinessFactor() != null ? p.getEasinessFactor() : 2.5)
                            .average()
                            .orElse(2.5);
                    return MyStatsResponse.CourseStat.builder()
                            .courseId(courseId)
                            .courseName(courseName)
                            .wordsLearned(wordsLearned)
                            .avgEf(avgEf)
                            .build();
                })
                .collect(Collectors.toList());

        return MyStatsResponse.builder()
                .totalWordsLearned(totalWordsLearned)
                .totalReviews(totalReviews)
                .averageAccuracy(averageAccuracy)
                .streakDays(0)
                .weeklyXp(0)
                .courseStats(courseStats)
                .build();
    }
}
