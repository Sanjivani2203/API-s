package com.example.spring_jpa_relationship.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_jpa_relationship.model.*;
import com.example.spring_jpa_relationship.service.Demoservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class Democontroller {

    private final Demoservice demoService;

    @PostMapping("/create")
    public User createData() {
        return demoService.createDemoData();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return demoService.getAllUsers();
    }

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return demoService.getAllOrders();
    }
}
