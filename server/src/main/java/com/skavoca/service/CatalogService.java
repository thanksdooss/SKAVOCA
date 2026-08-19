package com.skavoca.service;

import com.skavoca.dto.CourseDto;
import com.skavoca.dto.WordDto;
import com.skavoca.entity.Word;
import com.skavoca.repository.CurriculumCourseRepository;
import com.skavoca.repository.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CatalogService {
    
    private final CurriculumCourseRepository courseRepository;
    private final WordRepository wordRepository;

    public CatalogService(CurriculumCourseRepository courseRepository, WordRepository wordRepository) {
        this.courseRepository = courseRepository;
        this.wordRepository = wordRepository;
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAllByOrderByOrderIndex().stream()
                .map(course -> CourseDto.builder()
                        .courseId(course.getCourseId())
                        .courseName(course.getCourseName())
                        .icon(course.getIcon())
                        .color(course.getColor())
                        .wordCount(wordRepository.countByCourse_CourseId(course.getCourseId()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<WordDto> getWordsForCourse(Integer courseId) {
        return wordRepository.findByCourse_CourseId(courseId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public WordDto getWordDetails(Long wordId) {
        return wordRepository.findById(wordId)
                .map(this::mapToDto)
                .orElse(null);
    }

    public List<WordDto> searchWords(String keyword) {
        return wordRepository.findByTermContainingIgnoreCase(keyword).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private WordDto mapToDto(Word word) {
        return WordDto.builder()
                .wordId(word.getWordId())
                .courseId(word.getCourse().getCourseId())
                .courseName(word.getCourse().getCourseName())
                .term(word.getTerm())
                .fullTerm(word.getFullTerm())
                .pronunciationKr(word.getPronunciationKr())
                .pronunciationSsml(word.getPronunciationSsml())
                .easyMeaning(word.getEasyMeaning())
                .contextSentence(word.getContextSentence())
                .difficulty(word.getDifficulty())
                .distractors(List.of())
                .build();
    }
}
