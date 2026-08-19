package com.skavoca.dto;

import lombok.Data;

@Data
public class SubmitAnswerRequest {
    private Long wordId;
    private String userInput;
    private Double responseTimeSec;
    private Integer hintCount;
    private Integer typoCount;
}
