package com.skavoca.service;

import com.skavoca.dto.DifficultWordDto;
import com.skavoca.dto.WordCreateRequest;
import com.skavoca.entity.CurriculumCourse;
import com.skavoca.entity.Word;
import com.skavoca.repository.CurriculumCourseRepository;
import com.skavoca.repository.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class AdminService {

    private final WordRepository wordRepository;
    private final CurriculumCourseRepository courseRepository;

    public AdminService(WordRepository wordRepository, CurriculumCourseRepository courseRepository) {
        this.wordRepository = wordRepository;
        this.courseRepository = courseRepository;
    }

    public List<DifficultWordDto> getDifficultWords(Integer cohort, Integer limit) {
        // Query to join UserProgress and aggregate EF. Mocking for now.
        return Collections.emptyList();
    }

    public void createWord(WordCreateRequest request) {
        CurriculumCourse course = courseRepository.findById(request.getCourseId())
            .orElseThrow(() -> new RuntimeException("Course not found"));
            
        Word word = Word.builder()
            .course(course)
            .term(request.getTerm())
            .fullTerm(request.getFullTerm())
            .pronunciationKr(request.getPronunciationKr())
            .pronunciationSsml(request.getPronunciationSsml())
            .easyMeaning(request.getEasyMeaning())
            .contextSentence(request.getContextSentence())
            .difficulty(request.getDifficulty() != null ? request.getDifficulty() : "MEDIUM")
            .build();
            
        wordRepository.save(word);
    }
}
