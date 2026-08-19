package com.skavoca.controller;

import com.skavoca.dto.CourseDto;
import com.skavoca.dto.WordDto;
import com.skavoca.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        return ResponseEntity.ok(catalogService.getAllCourses());
    }

    @GetMapping("/courses/{courseId}/words")
    public ResponseEntity<List<WordDto>> getWordsForCourse(@PathVariable Integer courseId) {
        return ResponseEntity.ok(catalogService.getWordsForCourse(courseId));
    }

    @GetMapping("/words/{wordId}")
    public ResponseEntity<WordDto> getWordDetails(@PathVariable Long wordId) {
        WordDto word = catalogService.getWordDetails(wordId);
        if (word == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(word);
    }

    @GetMapping("/words/search")
    public ResponseEntity<List<WordDto>> searchWords(@RequestParam("q") String keyword) {
        return ResponseEntity.ok(catalogService.searchWords(keyword));
    }
}
