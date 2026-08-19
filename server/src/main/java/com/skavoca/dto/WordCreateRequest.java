package com.skavoca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WordCreateRequest {
    @NotNull
    private Integer courseId;
    @NotBlank
    private String term;
    private String fullTerm;
    private String pronunciationKr;
    private String pronunciationSsml;
    @NotBlank
    private String easyMeaning;
    @NotBlank
    private String contextSentence;
    private String difficulty;
}
