package com.example.apps.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductType {
    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
