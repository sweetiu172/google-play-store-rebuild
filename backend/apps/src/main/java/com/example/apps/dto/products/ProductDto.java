package com.example.apps.dto.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

public class ProductDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateProductRequest {
        private String name;
        private String description;

        private Set<Long> categories;
        private List<String> imageUrls;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductVm {
        private Long id;
        private String name;
        private String description;

        private Set<CategoryDto.CategoryVm> categories;
        private List<String> imageUrls;
    }
}
