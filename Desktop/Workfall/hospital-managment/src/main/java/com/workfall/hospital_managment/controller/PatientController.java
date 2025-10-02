package com.workfall.hospital_managment.controller;

import com.workfall.hospital_managment.dto.PatientDTO;
import com.workfall.hospital_managment.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // ✅ Create Patient
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PatientDTO dto) {
        try {
            return ResponseEntity.ok(patientService.savePatient(dto));
        } catch (IllegalArgumentException e) {
            return buildError(e.getMessage());
        }
    }

    // ✅ Get All Patients
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAll() {
        return ResponseEntity.ok(patientService.getAll());
    }

    // ✅ Update Patient
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PatientDTO dto) {
        try {
            return ResponseEntity.ok(patientService.updatePatient(id, dto));
        } catch (IllegalArgumentException e) {
            return buildError(e.getMessage());
        }
    }

    // ✅ Delete Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            patientService.deletePatient(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return buildError(e.getMessage());
        }
    }

    // ✅ Search + Pagination
    @GetMapping("/search")
    public ResponseEntity<List<PatientDTO>> searchPatients(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String disease,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(patientService.searchPatients(name, disease, page, size));
    }

    // Helper for errors
    private ResponseEntity<Map<String, String>> buildError(String msg) {
        Map<String, String> error = new HashMap<>();
        error.put("error", msg);
        return ResponseEntity.badRequest().body(error);
    }
}
