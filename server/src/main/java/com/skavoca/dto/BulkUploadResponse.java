package com.skavoca.dto;

import lombok.Data;

@Data
public class BulkUploadResponse {
    private int created;
    private int failed;
    
    public BulkUploadResponse(int created, int failed) {
        this.created = created;
        this.failed = failed;
    }
}
