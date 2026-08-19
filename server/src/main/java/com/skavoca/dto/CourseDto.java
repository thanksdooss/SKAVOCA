package com.skavoca.dto;

import lombok.Builder;

@Builder
public record CourseDto(
    Integer courseId,
    String courseName,
    String icon,
    String color,
    Long wordCount
) {}
