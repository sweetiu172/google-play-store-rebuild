package com.example.apps.service;

import com.example.apps.dto.products.CategoryDto;
import com.example.apps.dto.products.ProductDto;
import com.example.apps.model.products.Product;
import com.example.apps.model.products.ProductImage;
import com.example.apps.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Transactional
    public void create(ProductDto.CreateProductRequest request) {
        var entity = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .categories(productRepository.getReferenceByIds(request.getCategories()))
                .build();
        productRepository.save(entity);
    }

    public List<ProductDto.ProductVm> findAll() {
        var entities = productRepository.findAllIncludeCategoriesAndImages();
        return entities.stream()
                .map(e -> new ProductDto.ProductVm(
                        e.getId(),
                        e.getName(),
                        e.getDescription(),
                        e.getCategories().stream()
                                .map(c -> new CategoryDto.CategoryVm(c.getId(), c.getName(), c.getDescription()))
                                        .collect(Collectors.toSet()),
                        e.getImages().stream()
                                .map(ProductImage::getImageUrl)
                                .toList()
                ))
                .toList();
    }
}
