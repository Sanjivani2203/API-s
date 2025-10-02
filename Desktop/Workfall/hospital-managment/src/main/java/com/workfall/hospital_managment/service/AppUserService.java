package com.workfall.hospital_managment.service;

import com.workfall.hospital_managment.dto.AppUserDTO;
import com.workfall.hospital_managment.entity.AppUser;
import com.workfall.hospital_managment.entity.Patient;
import com.workfall.hospital_managment.repository.AppUserRepository;
import com.workfall.hospital_managment.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepo;

    @Autowired
    private PatientRepository patientRepo;

    // ✅ Create User
    public AppUserDTO saveUser(AppUserDTO dto) {
        AppUser user = new AppUser();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());

        if (dto.getPatientId() != null) {
            Patient patient = patientRepo.findById(dto.getPatientId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Patient ID " + dto.getPatientId() + " not found."));
            user.setPatient(patient);
        }

        user = appUserRepo.save(user);
        dto.setId(user.getId());
        return dto;
    }

    // ✅ Get All Users
    public List<AppUserDTO> getAll() {
        return appUserRepo.findAll().stream().map(u ->
                new AppUserDTO(
                        u.getId(),
                        u.getUsername(),
                        u.getPassword(),
                        u.getEmail(),
                        u.getRole(),
                        u.getPatient() != null ? u.getPatient().getId() : null
                )
        ).toList();
    }

    // ✅ Update User
    public AppUserDTO updateUser(Long id, AppUserDTO dto) {
        AppUser user = appUserRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User ID " + id + " not found."));

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());

        if (dto.getPatientId() != null) {
            Patient patient = patientRepo.findById(dto.getPatientId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Patient ID " + dto.getPatientId() + " not found."));
            user.setPatient(patient);
        }

        appUserRepo.save(user);
        dto.setId(user.getId());
        return dto;
    }

    // ✅ Delete User
    public void deleteUser(Long id) {
        if (!appUserRepo.existsById(id)) {
            throw new IllegalArgumentException("User ID " + id + " not found.");
        }
        appUserRepo.deleteById(id);
    }

    // ✅ Search Users with Pagination
    public List<AppUserDTO> searchUsers(String username, String role, int page, int size) {
        return appUserRepo.searchUsers(username, role, page, size)
                .stream()
                .map(u -> new AppUserDTO(
                        u.getId(),
                        u.getUsername(),
                        u.getPassword(),
                        u.getEmail(),
                        u.getRole(),
                        u.getPatient() != null ? u.getPatient().getId() : null
                ))
                .toList();
    }
}
