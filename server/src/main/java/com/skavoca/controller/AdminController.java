package com.skavoca.controller;

import com.skavoca.dto.DifficultWordDto;
import com.skavoca.dto.WordCreateRequest;
import com.skavoca.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/analytics/difficult-words")
    public ResponseEntity<List<DifficultWordDto>> getDifficultWords(
            @RequestParam(defaultValue = "4") Integer cohort,
            @RequestParam(defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(adminService.getDifficultWords(cohort, limit));
    }

    @PostMapping("/words")
    public ResponseEntity<Void> createWord(@Valid @RequestBody WordCreateRequest request) {
        adminService.createWord(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/words/bulk-upload")
    public ResponseEntity<com.skavoca.dto.BulkUploadResponse> bulkUploadWords(@Valid @RequestBody List<WordCreateRequest> requests) {
        return ResponseEntity.ok(adminService.bulkUploadWords(requests));
    }

    @PutMapping("/words/{wordId}")
    public ResponseEntity<Void> updateWord(@PathVariable Long wordId, @Valid @RequestBody WordCreateRequest request) {
        adminService.updateWord(wordId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/words/{wordId}")
    public ResponseEntity<Void> deleteWord(@PathVariable Long wordId) {
        adminService.deleteWord(wordId);
        return ResponseEntity.ok().build();
    }
}
