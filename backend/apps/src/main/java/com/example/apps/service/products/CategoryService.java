package com.example.apps.service.products;

import com.example.apps.dto.products.CategoryDto;
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
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDto.CategoryVm> findAll() {
        var entities = categoryRepository.findAll();
        return entities.stream()
                .map(entity ->
                        new CategoryDto.CategoryVm(entity.getId(), entity.getName(), entity.getDescription())
                )
                .toList();
    }

    @Transactional
    public void create(CategoryDto.CreateCategoryRequest request) {
        var entity = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        categoryRepository.save(entity);
    }

    @Transactional
    public void update(Long id, CategoryDto.UpdateRequest request) {
        var entity = categoryRepository.findById(id).orElseThrow();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        categoryRepository.save(entity);
    }

    @Transactional
    public void delete(Long id) {
        var entity = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(entity);
    }

    public List<Category> findByIds(Iterable<Long> ids) {
        return categoryRepository.findAllById(ids);
    }
}
