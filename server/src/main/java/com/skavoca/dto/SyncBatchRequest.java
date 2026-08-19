package com.skavoca.dto;

import lombok.Data;
import java.util.List;

@Data
public class SyncBatchRequest {
    private List<SubmitAnswerRequest> items;
}
