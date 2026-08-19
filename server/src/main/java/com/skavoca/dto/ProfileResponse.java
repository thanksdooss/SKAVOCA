package com.skavoca.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {
    private Long userId;
    private String nickname;
    private String role;
    private String tier;
    private Long xp;
    private Integer streakDays;
    private String currentLeague;
}
