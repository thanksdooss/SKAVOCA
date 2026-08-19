package com.skavoca.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEW_LOGS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ReviewLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_logs_seq")
    @SequenceGenerator(name = "review_logs_seq", sequenceName = "review_logs_seq", allocationSize = 1)
    @Column(name = "log_id")
    private Long logId;
    
    @Column(name = "local_log_id")
    private String localLogId;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", nullable = false)
    private Word word;
    
    @Builder.Default
    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect = true;
    
    @Builder.Default
    @Column(name = "xp_earned", nullable = false)
    private Integer xpEarned = 0;
    
    @Column(name = "inferred_quality", nullable = false)
    private Integer inferredQuality;
    
    @Column(name = "response_time_sec", nullable = false)
    private Double responseTimeSec;
    
    @Column(name = "hint_count")
    private Integer hintCount;
    
    @Column(name = "typo_count")
    private Integer typoCount;
    
    @Column(name = "calculated_ef", nullable = false)
    private Double calculatedEf;
    
    @Column(name = "review_interval", nullable = false)
    private Integer reviewInterval;
    
    @Builder.Default
    @Column(name = "reviewed_at")
    private LocalDateTime reviewedAt = LocalDateTime.now();
}
