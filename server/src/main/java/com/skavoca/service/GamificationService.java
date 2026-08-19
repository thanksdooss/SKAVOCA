package com.skavoca.service;

import com.skavoca.dto.LeagueResponse;
import com.skavoca.dto.ProfileResponse;
import com.skavoca.entity.User;
import com.skavoca.entity.WeeklyLeague;
import com.skavoca.repository.UserRepository;
import com.skavoca.repository.WeeklyLeagueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GamificationService {

    private final UserRepository userRepository;
    private final WeeklyLeagueRepository leagueRepository;

    public GamificationService(UserRepository userRepository, WeeklyLeagueRepository leagueRepository) {
        this.userRepository = userRepository;
        this.leagueRepository = leagueRepository;
    }

    public LeagueResponse getLeague(Integer cohort, Long userId) {
        LocalDate weekStart = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        List<WeeklyLeague> leagues = leagueRepository.findByCohortAndWeekStartDateOrderByWeeklyXpDesc(cohort, weekStart);
        
        int rank = 1;
        Integer myRank = null;
        Integer myXp = 0;
        
        for (WeeklyLeague l : leagues) {
            l.setRankPosition(rank);
            if (l.getUser().getUserId().equals(userId)) {
                myRank = rank;
                myXp = l.getWeeklyXp();
            }
            rank++;
        }
        
        List<LeagueResponse.LeaderboardEntry> leaderboard = leagues.stream()
            .map(l -> LeagueResponse.LeaderboardEntry.builder()
                .rank(l.getRankPosition())
                .userId(l.getUser().getUserId())
                .nickname(l.getUser().getNickname())
                .tier(l.getUser().getTier())
                .weeklyXp(l.getWeeklyXp())
                .build())
            .collect(Collectors.toList());

        return LeagueResponse.builder()
            .cohort(cohort)
            .leagueTier(leagues.isEmpty() ? "브론즈 리그" : leagues.get(0).getLeagueTier())
            .weekEndDate(weekStart.plusDays(6))
            .myRank(myRank != null ? myRank : 0)
            .myWeeklyXp(myXp)
            .leaderboard(leaderboard)
            .build();
    }

    public ProfileResponse getProfile(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
            
        return ProfileResponse.builder()
            .userId(user.getUserId())
            .nickname(user.getNickname())
            .role(user.getRole())
            .tier(user.getTier())
            .xp(user.getXp())
            .streakDays(user.getStreakDays())
            .currentLeague("골드 리그") // Placeholder
            .build();
    }

    public void awardXp(Long userId, int xpAmount) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
            
        user.setXp(user.getXp() + xpAmount);
        
        // Tier promotion logic
        if (user.getXp() >= 10000) user.setTier("전설의 CTO");
        else if (user.getXp() >= 5000) user.setTier("다이아몬드 아키텍트");
        else if (user.getXp() >= 2500) user.setTier("테크 리드");
        else if (user.getXp() >= 1000) user.setTier("시니어 개발자");
        else if (user.getXp() >= 300) user.setTier("주니어 개발자");
        else user.setTier("코딩 노비");
        
        userRepository.save(user);

        LocalDate weekStart = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        WeeklyLeague league = leagueRepository.findByUser_UserIdAndWeekStartDate(userId, weekStart)
            .orElseGet(() -> WeeklyLeague.builder()
                .user(user)
                .cohort(user.getCohort())
                .leagueTier("실버 리그")
                .weeklyXp(0)
                .rankPosition(0)
                .weekStartDate(weekStart)
                .build());
                
        league.setWeeklyXp(league.getWeeklyXp() + xpAmount);
        leagueRepository.save(league);
    }
}
