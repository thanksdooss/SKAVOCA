package com.skavoca.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class WordDto {
    private Long wordId;
    private Integer courseId;
    private String courseName;
    private String term;
    private String fullTerm;
    private String pronunciationKr;
    private String pronunciationSsml;
    private String easyMeaning;
    private String contextSentence;
    private String difficulty;
    private List<String> distractors;
}
