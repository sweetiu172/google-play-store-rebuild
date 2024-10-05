package com.example.apps.model.review;

import com.example.apps.model.AbstractAuditEntity;
import com.example.apps.model.products.Product;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_reviews")
public class ProductReview extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_review_product_seq_generator")
    @SequenceGenerator(name = "user_review_product_seq_generator",
            sequenceName = "user_review_product_seq", allocationSize = 25)
    private Long id;

    private Long userId;
    private short rating;

    @Lob
    private String text;

    @ColumnDefault("0")
    private long helpfulCount;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
