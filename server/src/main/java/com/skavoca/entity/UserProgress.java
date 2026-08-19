package com.skavoca.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_PROGRESS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "word_id"})
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserProgress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "progress_seq")
    @SequenceGenerator(name = "progress_seq", sequenceName = "progress_seq", allocationSize = 1)
    @Column(name = "progress_id")
    private Long progressId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", nullable = false)
    private Word word;
    
    private Integer repetitions;
    
    @Column(name = "interval_days")
    private Integer intervalDays;
    
    @Column(name = "easiness_factor")
    private Double easinessFactor;
    
    @Column(name = "next_practice_date", nullable = false)
    private LocalDateTime nextPracticeDate;
    
    @Column(name = "last_reviewed_at")
    private LocalDateTime lastReviewedAt;
    
    @Column(name = "total_reviews")
    private Integer totalReviews;
    
    @Column(name = "total_lapses")
    private Integer totalLapses;
}
