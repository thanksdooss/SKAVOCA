package com.skavoca.controller;

import com.skavoca.dto.SubmitAnswerResponse.Feedback;
import com.skavoca.service.AiFeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
public class AiFeedbackController {

    private final AiFeedbackService aiFeedbackService;

    public AiFeedbackController(AiFeedbackService aiFeedbackService) {
        this.aiFeedbackService = aiFeedbackService;
    }

    @PostMapping("/explain-distractor")
    public ResponseEntity<Feedback> explainDistractor(@RequestParam Long wordId, @RequestParam String wrongInput) {
        return ResponseEntity.ok(aiFeedbackService.getDistractorFeedback(wordId, wrongInput));
    }
}
