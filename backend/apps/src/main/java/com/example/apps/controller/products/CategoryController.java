package com.example.apps.controller.products;

import com.example.apps.dto.common.Error;
import com.example.apps.dto.common.ResponseVm;
import com.example.apps.dto.products.CategoryDto;
import com.example.apps.service.products.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ResponseVm<List<CategoryDto.CategoryVm>>> getAll() {
        return ResponseEntity.ok(new ResponseVm<>(200, "OK", categoryService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseVm<Void>> create(@RequestBody CategoryDto.CreateCategoryRequest request) {
        categoryService.create(request);
        return ResponseEntity.ok(new ResponseVm<>(Error.SUCCESS));
    }
}
