package com.skavoca.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CURRICULUM_COURSES")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CurriculumCourse {
    
    @Id
    @Column(name = "course_id")
    private Integer courseId;
    
    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;
    
    @Column(length = 20)
    private String icon;
    
    @Column(length = 20)
    private String color;
    
    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;
}
