package com.skavoca.controller;

import com.skavoca.dto.MyStatsResponse;
import com.skavoca.service.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/my")
    public ResponseEntity<MyStatsResponse> getMyStats() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId;
        if (principal instanceof Long) {
            userId = (Long) principal;
        } else {
            userId = Long.valueOf(principal.toString());
        }
        return ResponseEntity.ok(statsService.getMyStats(userId));
    }
}
