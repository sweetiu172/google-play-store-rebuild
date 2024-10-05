package com.example.apps.dto.pagination;

import lombok.Data;

@Data
public class BasePaginateRequest {
    private int page = 0;
    private int pageSize = 15;
    private String orderBy;
}
