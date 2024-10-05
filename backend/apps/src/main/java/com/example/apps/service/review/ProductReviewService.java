package com.example.apps.service.review;

import com.example.apps.dto.pagination.BasePaginateRequest;
import com.example.apps.dto.review.ReviewDto;
import com.example.apps.model.review.ProductReview;
import com.example.apps.repository.ProductReviewRepository;
import com.example.apps.service.products.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductReviewService {
    private final ProductReviewRepository productReviewRepository;
    private final ProductService productService;

    public List<ReviewDto.ReviewVm> findByProductId(Long productId, BasePaginateRequest request) {
        var product = productService.findById(productId);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }
        var pageable = PageRequest.of(request.getPage(), request.getPageSize());
        return productReviewRepository.findByProduct(product.get(), pageable)
                .stream()
                .map(o -> ReviewDto.ReviewVm.builder()
                        .id(o.getId())
                        .userId(o.getUserId())
                        .rating(o.getRating())
                        .text(o.getText())
                        .helpfulCount(o.getHelpfulCount())
                        .build())
                .toList();
    }

    @Transactional
    public void create(ReviewDto.CreateRequest request) {
        var product = productService.findById(request.getProductId());
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }
        var entity = ProductReview.builder()
                .userId(1L)
                .product(product.get())
                .rating(request.getRating())
                .text(request.getText())
                .build();
        productReviewRepository.save(entity);
    }
}
