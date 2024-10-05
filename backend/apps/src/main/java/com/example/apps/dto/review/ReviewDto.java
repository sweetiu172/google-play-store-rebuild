package com.example.apps.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReviewDto {

    @Data
    public static class CreateRequest {
        @NotNull(message = "Rating is required")
        @Min(value = 1, message = "Rating must be greater than or equal to 1")
        @Max(value = 5, message = "Rating must be less than or equal to 5")
        private Short rating;

        @NotNull(message = "Text is required")
        private String text;

        @NotNull(message = "Product id is required")
        @Min(value = 1, message = "Product id must be greater than or equal to 1")
        private Long productId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReviewVm {
        private Long id;
        private Long userId;
        private Short rating;
        private String text;
        private long helpfulCount;
    }
}
