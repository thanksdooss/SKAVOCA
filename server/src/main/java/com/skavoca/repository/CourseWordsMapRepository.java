package com.skavoca.repository;

import com.skavoca.entity.CourseWordsMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseWordsMapRepository extends JpaRepository<CourseWordsMap, Long> {
    List<CourseWordsMap> findByCurriculumCourse_CourseId(Integer courseId);
    List<CourseWordsMap> findByWord_WordId(Long wordId);
}
