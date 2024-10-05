package com.example.apps.repository;

import com.example.apps.model.products.Product;
import com.example.apps.model.review.ProductReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long>, PagingAndSortingRepository<ProductReview, Long> {
    Page<ProductReview> findByProduct(Product product, Pageable pageable);
}
