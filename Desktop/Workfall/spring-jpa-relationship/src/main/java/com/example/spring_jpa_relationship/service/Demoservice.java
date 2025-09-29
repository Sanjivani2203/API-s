package com.example.spring_jpa_relationship.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.spring_jpa_relationship.model.*;
import com.example.spring_jpa_relationship.repository.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Demoservice {

    private final Userrepositriy userRepository;
    private final Addressrepository addressRepository;
    private final Ordersrepositotry ordersRepository;
    private final Productrepositotry productRepository;

    // Create demo data
    public User createDemoData() {
        // Address
        Address address = Address.builder()
                .street("MG Road")
                .city("Pune")
                .state("MH")
                .zipcode("411001")
                .build();

        // Products
        Product p1 = Product.builder().name("Laptop").category("Electronics").price(55000).stock(10).build();
        Product p2 = Product.builder().name("Phone").category("Electronics").price(25000).stock(30).build();

        productRepository.saveAll(Arrays.asList(p1, p2));

        // User
        User user = User.builder()
                .name("John Doe")
                .email("john@example.com")
                .phone("9876543210")
                .age(28)
                .address(address)
                .build();

        // Order
        Orders order = Orders.builder()
                .orderDate("2025-09-24")
                .totalAmount(80000)
                .status("PAID")
                .paymentMode("UPI")
                .user(user)
                .products(Arrays.asList(p1, p2))
                .build();

        user.setOrders(List.of(order));

        return userRepository.save(user);
    }

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Fetch all orders
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }
}
