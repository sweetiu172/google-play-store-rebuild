package com.example.apps.dto.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductTypeDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductTypeVm {
        private Long id;
        private String name;
        private String description;
    }

    @Data
    public static class CreateProductTypeRequest {
        private String name;
        private String description;
    }
}
