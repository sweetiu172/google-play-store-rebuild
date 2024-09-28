package com.example.apps.repository;

import com.example.apps.model.products.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = {"categories", "images"})
    @Query("select p from Product p")
    List<Product> findAllIncludeCategoriesAndImages();
}
