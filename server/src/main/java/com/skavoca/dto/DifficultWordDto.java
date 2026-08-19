package com.skavoca.dto;

public record DifficultWordDto(
    String term,
    String pronunciationKr,
    String courseName,
    Double ef,
    Double failRate
) {}
