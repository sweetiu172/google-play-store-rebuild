package com.example.apps.service.products;

import com.example.apps.model.products.ProductCategory;
import com.example.apps.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final CategoryService categoryService;

    public List<ProductCategory> createEntities(Iterable<Long> categoryIds) {
        var categoryEntities = categoryService.findByIds(categoryIds);
        return categoryEntities.stream()
                .map(o -> ProductCategory.builder()
                        .category(o)
                        .build()
                )
                .toList();
    }
}
