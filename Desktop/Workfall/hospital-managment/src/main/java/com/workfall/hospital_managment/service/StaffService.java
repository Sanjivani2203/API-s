package com.workfall.hospital_managment.service;

import com.workfall.hospital_managment.dto.StaffDTO;
import com.workfall.hospital_managment.entity.Hospital;
import com.workfall.hospital_managment.entity.Staff;
import com.workfall.hospital_managment.repository.HospitalRepository;
import com.workfall.hospital_managment.repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepo;

    @Autowired
    private HospitalRepository hospitalRepo;

    public StaffDTO saveStaff(StaffDTO dto) {
        Staff staff = new Staff();
        staff.setStaffName(dto.getStaffName());
        staff.setRole(dto.getRole());
        staff.setDepartment(dto.getDepartment());
        staff.setSalary(dto.getSalary());
        Hospital hospital = hospitalRepo.findById(dto.getHospitalId()).orElseThrow();
        staff.setHospital(hospital);
        staff = staffRepo.save(staff);
        dto.setId(staff.getId());
        return dto;
    }

    public List<StaffDTO> getAll() {
        return staffRepo.findAll().stream().map(s ->
                new StaffDTO(s.getId(), s.getStaffName(), s.getRole(),
                        s.getDepartment(), s.getSalary(),
                        s.getHospital().getId())).toList();
    }

    public StaffDTO updateStaff(Long id, StaffDTO dto) {
        Staff staff = staffRepo.findById(id).orElseThrow();
        staff.setStaffName(dto.getStaffName());
        staff.setRole(dto.getRole());
        staff.setDepartment(dto.getDepartment());
        staff.setSalary(dto.getSalary());
        Hospital hospital = hospitalRepo.findById(dto.getHospitalId()).orElseThrow();
        staff.setHospital(hospital);
        staffRepo.save(staff);
        dto.setId(staff.getId());
        return dto;
    }

    public void deleteStaff(Long id) {
        staffRepo.deleteById(id);
    }

    // ✅ Pagination + search
    public List<StaffDTO> searchStaff(String name, String role, int page, int size) {
        return staffRepo.searchStaff(name, role, page, size)
                .stream()
                .map(s -> new StaffDTO(
                        s.getId(),
                        s.getStaffName(),
                        s.getRole(),
                        s.getDepartment(),
                        s.getSalary(),
                        s.getHospital().getId()
                ))
                .toList();
    }
}
