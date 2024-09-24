package com.example.search.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.search.model.elasticsearch.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

}
