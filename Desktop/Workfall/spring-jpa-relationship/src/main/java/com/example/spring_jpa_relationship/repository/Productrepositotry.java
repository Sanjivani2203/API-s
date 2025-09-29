package com.example.spring_jpa_relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_jpa_relationship.model.Product;

public interface Productrepositotry extends JpaRepository<Product, Long>{

}
