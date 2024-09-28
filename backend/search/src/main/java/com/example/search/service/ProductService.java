package com.example.search.service;

import com.example.search.model.elasticsearch.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ElasticsearchOperations elasticsearchOperations;

    public long saveIndex(Product product) {
        var productEntity = elasticsearchOperations.save(product);
        return productEntity.getId();
    }

    public List<Long> saveBatchIndex(List<Product> products) {
        var ids = new ArrayList<Long>();
        elasticsearchOperations.save(products).forEach(o -> ids.add(o.getId()));
        return ids;
    }

    
}
