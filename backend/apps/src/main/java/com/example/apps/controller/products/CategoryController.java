package com.example.apps.controller.products;

import com.example.apps.dto.common.Error;
import com.example.apps.dto.common.ResponseVm;
import com.example.apps.dto.products.CategoryDto;
import com.example.apps.service.products.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Categories", description = "Operations for categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get all categories")
    public ResponseEntity<ResponseVm<List<CategoryDto.CategoryVm>>> getAll() {
        return ResponseEntity.ok(new ResponseVm<>(200, "OK", categoryService.findAll()));
    }

    @PostMapping
    @Operation(summary = "Create a new category")
    public ResponseEntity<ResponseVm<Void>> create(@RequestBody CategoryDto.CreateCategoryRequest request) {
        categoryService.create(request);
        return ResponseEntity.ok(new ResponseVm<>(Error.SUCCESS));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a category")
    public ResponseEntity<ResponseVm<Void>> update(@PathVariable Long id,
                                                   @RequestBody CategoryDto.UpdateRequest request) {
        categoryService.update(id, request);

        return ResponseEntity.ok(new ResponseVm<>(Error.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a category")
    public ResponseEntity<ResponseVm<Void>> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok(new ResponseVm<>(Error.SUCCESS));
    }
}
