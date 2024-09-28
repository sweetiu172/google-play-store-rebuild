package com.example.apps.controller.products;

import com.example.apps.dto.common.Error;
import com.example.apps.dto.common.ResponseVm;
import com.example.apps.dto.products.ProductTypeDto;
import com.example.apps.service.ProductService;
import com.example.apps.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-types")
@RequiredArgsConstructor
public class ProductTypeController {
    private final ProductTypeService productTypeService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ResponseVm<List<ProductTypeDto.ProductTypeVm>>> getAll() {
        return ResponseEntity.ok(new ResponseVm<>(200, "OK", productTypeService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseVm<Void>> create(@RequestBody ProductTypeDto.CreateProductTypeRequest request) {
        productTypeService.create(request);
        return ResponseEntity.ok(new ResponseVm<>(Error.SUCCESS));
    }
}
