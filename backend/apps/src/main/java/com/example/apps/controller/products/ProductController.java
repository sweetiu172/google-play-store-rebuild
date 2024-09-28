package com.example.apps.controller.products;

import com.example.apps.dto.common.Error;
import com.example.apps.dto.common.ResponseVm;
import com.example.apps.dto.products.ProductDto;
import com.example.apps.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ResponseVm<List<ProductDto.ProductVm>>> getAll() {
        return ResponseEntity.ok(new ResponseVm<>(200, "OK", productService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseVm<Void>> create(@RequestBody ProductDto.CreateProductRequest request) {
        productService.create(request);
        return ResponseEntity.ok(new ResponseVm<>(Error.SUCCESS));
    }
}
