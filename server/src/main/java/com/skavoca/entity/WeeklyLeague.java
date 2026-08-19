package com.skavoca.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "WEEKLY_LEAGUE")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class WeeklyLeague {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "league_seq")
    @SequenceGenerator(name = "league_seq", sequenceName = "league_seq", allocationSize = 1)
    @Column(name = "league_id")
    private Long leagueId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    private Integer cohort;
    
    @Column(name = "league_tier", length = 50)
    private String leagueTier;
    
    @Column(name = "weekly_xp")
    private Integer weeklyXp;
    
    @Column(name = "rank_position")
    private Integer rankPosition;
    
    @Column(name = "week_start_date", nullable = false)
    private LocalDate weekStartDate;
}
