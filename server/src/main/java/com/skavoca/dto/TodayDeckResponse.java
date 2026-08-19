package com.skavoca.dto;

import java.util.List;

public record TodayDeckResponse(
    List<WordDto> reviewWords,
    List<WordDto> newWords,
    int totalCount
) {}
