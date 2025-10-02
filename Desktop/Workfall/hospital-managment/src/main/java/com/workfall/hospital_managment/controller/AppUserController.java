package com.workfall.hospital_managment.controller;

import com.workfall.hospital_managment.dto.AppUserDTO;
import com.workfall.hospital_managment.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    // ✅ Create User
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AppUserDTO dto) {
        try {
            return ResponseEntity.ok(appUserService.saveUser(dto));
        } catch (IllegalArgumentException e) {
            return buildError(e.getMessage());
        }
    }

    // ✅ Get All Users
    @GetMapping
    public ResponseEntity<List<AppUserDTO>> getAll() {
        return ResponseEntity.ok(appUserService.getAll());
    }

    // ✅ Update User
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AppUserDTO dto) {
        try {
            return ResponseEntity.ok(appUserService.updateUser(id, dto));
        } catch (IllegalArgumentException e) {
            return buildError(e.getMessage());
        }
    }

    // ✅ Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            appUserService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return buildError(e.getMessage());
        }
    }

    // ✅ Search with Pagination
    @GetMapping("/search")
    public ResponseEntity<List<AppUserDTO>> searchUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String role,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(appUserService.searchUsers(username, role, page, size));
    }

    // Helper method
    private ResponseEntity<Map<String, String>> buildError(String msg) {
        Map<String, String> error = new HashMap<>();
        error.put("error", msg);
        return ResponseEntity.badRequest().body(error);
    }
}
