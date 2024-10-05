package com.example.apps.controller.reviews;

import com.example.apps.dto.pagination.BasePaginateRequest;
import com.example.apps.dto.review.ReviewDto;
import com.example.apps.service.review.ProductReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
@Tag(name = "Reviews", description = "Operations for product reviews")
public class ProductReviewController {
    private final ProductReviewService productReviewService;

    @GetMapping("/product/{product_id}")
    public List<ReviewDto.ReviewVm> getByProduct(@PathVariable @NonNull @Min(1) Long productId, BasePaginateRequest request) {
        return
    }
}
