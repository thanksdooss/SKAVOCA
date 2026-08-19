package com.skavoca.repository;

import com.skavoca.entity.CurriculumCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CurriculumCourseRepository extends JpaRepository<CurriculumCourse, Integer> {
    List<CurriculumCourse> findAllByOrderByOrderIndex();
}
