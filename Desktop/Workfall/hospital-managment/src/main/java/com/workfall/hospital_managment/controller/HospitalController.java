package com.workfall.hospital_managment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.workfall.hospital_managment.dto.HospitalDTO;
import com.workfall.hospital_managment.entity.Hospital;
import com.workfall.hospital_managment.service.HospitalService;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    // --- Create Hospital using DTO ---
    @PostMapping
    public ResponseEntity<?> create(@RequestBody HospitalDTO dto) {
        try {
            HospitalDTO savedDto = hospitalService.saveHospital(dto);
            return ResponseEntity.ok(savedDto);
        } catch (IllegalArgumentException e) {
            return buildErrorResponse(e.getMessage());
        }
    }

    // --- Create Hospital with Patients (full entity) ---
    @PostMapping("/patients")
    public ResponseEntity<?> createHospitalWithPatients(@RequestBody Hospital hospital) {
        try {
            Hospital savedHospital = hospitalService.saveHospitalWithPatients(hospital);
            return ResponseEntity.ok(savedHospital);
        } catch (IllegalArgumentException e) {
            return buildErrorResponse(e.getMessage());
        }
    }

    // --- Get all hospitals ---
    @GetMapping
    public ResponseEntity<List<HospitalDTO>> getAll() {
        return ResponseEntity.ok(hospitalService.getAll());
    }

    // --- Update hospital using DTO ---
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HospitalDTO dto) {
        try {
            HospitalDTO updatedDto = hospitalService.updateHospital(id, dto);
            return ResponseEntity.ok(updatedDto);
        } catch (IllegalArgumentException e) {
            return buildErrorResponse(e.getMessage());
        }
    }

    // --- Delete hospital ---
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            hospitalService.deleteHospital(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return buildErrorResponse(e.getMessage());
        }
    }

    // --- Helper method to return JSON error response ---
    private ResponseEntity<Map<String, String>> buildErrorResponse(String message) {
        Map<String, String> error = new HashMap<>();
        error.put("error", message);
        return ResponseEntity.badRequest().body(error);
    }
}
