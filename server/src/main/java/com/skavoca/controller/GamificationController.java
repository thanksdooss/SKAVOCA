package com.skavoca.controller;

import com.skavoca.dto.LeagueResponse;
import com.skavoca.dto.ProfileResponse;
import com.skavoca.service.GamificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gamification")
public class GamificationController {

    private final GamificationService gamificationService;

    public GamificationController(GamificationService gamificationService) {
        this.gamificationService = gamificationService;
    }

    private Long getCurrentUserId() {
        return (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/league")
    public ResponseEntity<LeagueResponse> getLeague(@RequestParam(defaultValue = "4") Integer cohort) {
        return ResponseEntity.ok(gamificationService.getLeague(cohort, getCurrentUserId()));
    }

    @GetMapping("/profile")
    public ResponseEntity<ProfileResponse> getProfile() {
        return ResponseEntity.ok(gamificationService.getProfile(getCurrentUserId()));
    }
}
