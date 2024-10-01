package com.example.apps.dto.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductCategoryDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ProductCategoryVm {
        private Long id;
        private CategoryDto.CategoryVm category;
    }
}
