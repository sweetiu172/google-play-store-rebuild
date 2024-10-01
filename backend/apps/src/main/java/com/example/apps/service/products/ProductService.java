package com.example.apps.service.products;

import com.example.apps.dto.products.CategoryDto;
import com.example.apps.dto.products.ProductCategoryDto;
import com.example.apps.dto.products.ProductDto;
import com.example.apps.model.products.Product;
import com.example.apps.model.products.ProductImage;
import com.example.apps.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryService productCategoryService;

    @Transactional
    public void create(ProductDto.CreateProductRequest request) {

        var productCategoryEntities = productCategoryService.createEntities(request.getCategories());

        var entity = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .images(request.getImageUrls().stream().map(o -> ProductImage.builder().imageUrl(o).build()).toList())
                .productCategories(productCategoryEntities)
                .build();


        productRepository.save(entity);
    }

    public List<ProductDto.ProductVm> findAll() {
//        var entities = productRepository.findAllIncludeCategoriesAndImages();
        return productRepository.findAllIncludeCategoriesAndImages()
                .stream()
                .map(o -> ProductDto.ProductVm.builder()
                        .id(o.getId())
                        .name(o.getName())
                        .description(o.getDescription())
                        .productCategories(o.getProductCategories().stream()
                                .map(p -> ProductCategoryDto.ProductCategoryVm.builder()
                                        .id(p.getId())
                                        .category(CategoryDto.CategoryVm.builder()
                                                .id(p.getCategory().getId())
                                                .name(p.getCategory().getName())
                                                .description(p.getCategory().getDescription())
                                                .build())
                                        .build()
                                ).toList())
                        .imageUrls(o.getImages().stream().map(ProductImage::getImageUrl).toList())
                        .build()
                )
                .toList();
    }

}
