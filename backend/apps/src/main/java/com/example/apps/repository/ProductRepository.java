package com.example.apps.repository;

import com.example.apps.model.products.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @EntityGraph(attributePaths = {"images"})
    @Query(value = "select p from Product p")
    List<Product> findAllFetchImages();

    @EntityGraph(attributePaths = {"productCategories", "productCategories.category"})
    @Query(value = "select p from Product p")
    List<Product> findAllFetchProductCategories();
}
