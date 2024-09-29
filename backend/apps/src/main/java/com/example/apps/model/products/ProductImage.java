package com.example.apps.model.products;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_image_seq_generator")
    @SequenceGenerator(name = "product_image_seq_generator",
            sequenceName = "product_image_seq", allocationSize = 25)
    private Long id;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
