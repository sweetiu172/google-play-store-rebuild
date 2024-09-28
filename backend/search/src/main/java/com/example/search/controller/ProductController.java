package com.example.search.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.search.service.ProductService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/search/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
}
