package com.skavoca.repository;

import com.skavoca.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByCourse_CourseId(Integer courseId);
    List<Word> findByTermContainingIgnoreCase(String keyword);
    Word findByTermIgnoreCase(String term);
    long countByCourse_CourseId(Integer courseId);
}
