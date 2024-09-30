package com.example.apps.model.products;

import com.example.apps.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
    @SequenceGenerator(name = "product_seq_generator",
            sequenceName = "product_seq", allocationSize = 25)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductImage> images;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST})
    private List<ProductCategory> productCategories;
}
