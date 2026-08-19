package com.skavoca.dto;

public record AuthResponse(
    String accessToken,
    String refreshToken,
    Long userId,
    String nickname,
    String role,
    String tier
) {}
