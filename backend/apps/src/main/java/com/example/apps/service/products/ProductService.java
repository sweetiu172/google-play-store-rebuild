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

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<ProductDto.ProductVm> findAll() {
        var products = productRepository.findAllFetchImages();
        var productsHasCategories = productRepository.findAllFetchProductCategories();

        var productCategoriesMap = new HashMap<Long, List<ProductCategoryDto.ProductCategoryVm>>();
        for (var productHasCategories : productsHasCategories) {
            var productCategoriesVm = productHasCategories.getProductCategories().stream()
                    .map(o -> ProductCategoryDto.ProductCategoryVm.builder()
                            .id(o.getId())
                            .category(CategoryDto.CategoryVm.builder()
                                    .id(o.getCategory().getId())
                                    .name(o.getCategory().getName())
                                    .description(o.getCategory().getDescription())
                                    .build())
                            .build())
                    .toList();
            productCategoriesMap.put(productHasCategories.getId(), productCategoriesVm);
        }

        return products.stream()
                .map(o -> ProductDto.ProductVm.builder()
                        .id(o.getId())
                        .name(o.getName())
                        .description(o.getDescription())
                        .productCategories(productCategoriesMap.get(o.getId()))
                        .imageUrls(o.getImages().stream().map(ProductImage::getImageUrl).toList())
                        .build())
                .toList();
    }

}
