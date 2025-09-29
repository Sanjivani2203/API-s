package com.example.spring_jpa_relationship.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDate;
    private double totalAmount;
    private String status;
    private String paymentMode;

    // Many-to-One with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Many-to-Many with Product
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
