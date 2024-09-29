package com.example.apps.repository;

import com.example.apps.model.products.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select * from categories where id in (?1)", nativeQuery = true)
    Set<Category> findSetById(Set<Long> ids);
}
