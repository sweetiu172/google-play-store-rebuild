package com.example.apps.model.products;

import com.example.apps.model.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_generator")
    @SequenceGenerator(name = "category_seq_generator",
            sequenceName = "category_seq", allocationSize = 25)
    private Long id;
    private String name;
    private String description;
}
