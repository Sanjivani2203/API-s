package com.workfall.hospital_managment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.workfall.hospital_managment.dto.HospitalDTO;
import com.workfall.hospital_managment.entity.Hospital;
import com.workfall.hospital_managment.repository.HospitalRepository;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepo;

    public HospitalDTO saveHospital(HospitalDTO dto) {
        Hospital hospital = new Hospital();
        hospital.setName(dto.getName());
        hospital.setAddress(dto.getAddress());
        hospital.setContactNumber(dto.getContactNumber());
        hospital.setType(dto.getType());

        hospital = hospitalRepo.save(hospital);
        dto.setId(hospital.getId());
        return dto;
    }

    public List<HospitalDTO> getAll() {
        return hospitalRepo.findAll().stream()
                .map(h -> new HospitalDTO(
                        h.getId(),
                        h.getName(),
                        h.getAddress(),
                        h.getContactNumber(),
                        h.getType()))
                .toList();
    }

    public HospitalDTO updateHospital(Long id, HospitalDTO dto) {
        Hospital hospital = hospitalRepo.findById(id).orElseThrow();
        hospital.setName(dto.getName());
        hospital.setAddress(dto.getAddress());
        hospital.setContactNumber(dto.getContactNumber());
        hospital.setType(dto.getType());

        hospitalRepo.save(hospital);
        dto.setId(hospital.getId());
        return dto;
    }

    public void deleteHospital(Long id) {
        hospitalRepo.deleteById(id);
    }

    public Hospital saveHospitalWithPatients(Hospital hospital) {
        if (hospital.getPatientList() != null) {
            hospital.getPatientList().forEach(p -> p.setHospital(hospital));
        }
        return hospitalRepo.save(hospital);
    }

    // --- New method for pagination + search ---
    public Page<Hospital> searchHospitals(String keyword, Pageable pageable) {
        return hospitalRepo.findByCriteria(keyword, pageable);
    }
}
