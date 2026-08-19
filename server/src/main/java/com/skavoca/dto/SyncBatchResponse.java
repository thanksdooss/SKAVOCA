package com.skavoca.dto;

import lombok.Data;
import java.util.List;

@Data
public class SyncBatchResponse {
    private List<SubmitAnswerResponse> results;
    private int successCount;
    private int failCount;
    
    public SyncBatchResponse(List<SubmitAnswerResponse> results, int successCount, int failCount) {
        this.results = results;
        this.successCount = successCount;
        this.failCount = failCount;
    }
}
