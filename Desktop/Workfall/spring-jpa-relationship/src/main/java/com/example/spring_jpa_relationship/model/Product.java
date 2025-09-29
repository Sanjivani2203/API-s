package com.example.spring_jpa_relationship.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private double price;
    private int stock;

    // Many-to-Many with Orders
    @ManyToMany(mappedBy = "products")
    private List<Orders> orders;
}
