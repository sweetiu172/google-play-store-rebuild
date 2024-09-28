package com.example.apps.service;

import com.example.apps.dto.products.ProductTypeDto;
import com.example.apps.model.products.Category;
import com.example.apps.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductTypeService {
    private final CategoryRepository productTypeRepository;

    public List<ProductTypeDto.ProductTypeVm> findAll() {
        var entities = productTypeRepository.findAll();
        return entities.stream()
                .map(entity ->
                        new ProductTypeDto.ProductTypeVm(entity.getId(), entity.getName(), entity.getDescription())
                )
                .toList();
    }

    @Transactional
    public void create(ProductTypeDto.CreateProductTypeRequest request) {
        var entity = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        productTypeRepository.save(entity);
    }
}
