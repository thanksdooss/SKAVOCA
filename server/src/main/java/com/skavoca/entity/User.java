package com.skavoca.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;
    
    @Column(unique = true, nullable = false, length = 100)
    private String email;
    
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    
    @Column(nullable = false, length = 50)
    private String nickname;
    
    @Column(length = 20)
    private String role;
    
    private Integer cohort;
    
    private Long xp;
    
    @Column(length = 50)
    private String tier;
    
    @Column(name = "streak_days")
    private Integer streakDays;
    
    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;
    
    @Builder.Default
    @Column(name = "login_fail_count", nullable = false)
    private Integer loginFailCount = 0;
    
    @Column(name = "lockout_until")
    private LocalDateTime lockoutUntil;
    
    @Builder.Default
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}

