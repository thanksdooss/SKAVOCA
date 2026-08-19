package com.skavoca.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class LeagueResponse {
    private Integer cohort;
    private String leagueTier;
    private LocalDate weekEndDate;
    private Integer myRank;
    private Integer myWeeklyXp;
    private List<LeaderboardEntry> leaderboard;

    @Data
    @Builder
    public static class LeaderboardEntry {
        private Integer rank;
        private Long userId;
        private String nickname;
        private String tier;
        private Integer weeklyXp;
    }
}
