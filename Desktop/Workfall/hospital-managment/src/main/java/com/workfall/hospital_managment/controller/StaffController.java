package com.workfall.hospital_managment.controller;

import com.workfall.hospital_managment.dto.StaffDTO;
import com.workfall.hospital_managment.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping
    public ResponseEntity<StaffDTO> create(@RequestBody StaffDTO dto) {
        return ResponseEntity.ok(staffService.saveStaff(dto));
    }

    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAll() {
        return ResponseEntity.ok(staffService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffDTO> update(@PathVariable Long id, @RequestBody StaffDTO dto) {
        return ResponseEntity.ok(staffService.updateStaff(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Search + Pagination
    @GetMapping("/search")
    public ResponseEntity<List<StaffDTO>> searchStaff(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String role,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(staffService.searchStaff(name, role, page, size));
    }
}
