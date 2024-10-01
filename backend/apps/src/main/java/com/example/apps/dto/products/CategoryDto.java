package com.example.apps.dto.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CategoryDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CategoryVm {
        private Long id;
        private String name;
        private String description;
    }

    @Data
    public static class CreateCategoryRequest {
        private String name;
        private String description;
    }
}
