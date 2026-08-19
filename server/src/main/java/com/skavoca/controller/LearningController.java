package com.skavoca.controller;

import com.skavoca.dto.SubmitAnswerRequest;
import com.skavoca.dto.SubmitAnswerResponse;
import com.skavoca.dto.TodayDeckResponse;
import com.skavoca.service.LearningService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/learning")
public class LearningController {

    private final LearningService learningService;

    public LearningController(LearningService learningService) {
        this.learningService = learningService;
    }

    private Long getCurrentUserId() {
        return (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/today")
    public ResponseEntity<TodayDeckResponse> getTodayDeck() {
        return ResponseEntity.ok(learningService.getTodayDeck(getCurrentUserId()));
    }

    @PostMapping("/submit-answer")
    public ResponseEntity<SubmitAnswerResponse> submitAnswer(@RequestBody SubmitAnswerRequest request) {
        return ResponseEntity.ok(learningService.submitAnswer(getCurrentUserId(), request));
    }

    @PostMapping("/sync-batch")
    public ResponseEntity<com.skavoca.dto.SyncBatchResponse> syncBatch(@RequestBody com.skavoca.dto.SyncBatchRequest request) {
        return ResponseEntity.ok(learningService.syncBatch(getCurrentUserId(), request));
    }
}
