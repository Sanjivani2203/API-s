package com.workfall.hospital_managment.service;

import com.workfall.hospital_managment.dto.PatientDTO;
import com.workfall.hospital_managment.entity.Hospital;
import com.workfall.hospital_managment.entity.Patient;
import com.workfall.hospital_managment.repository.HospitalRepository;
import com.workfall.hospital_managment.repository.PatientRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private HospitalRepository hospitalRepo;

    @PersistenceContext
    private EntityManager entityManager;

    // ✅ Save Patient
    public PatientDTO savePatient(PatientDTO dto) {
        Hospital hospital = hospitalRepo.findById(dto.getHospitalId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Hospital ID " + dto.getHospitalId() + " not found."));

        Patient patient = new Patient();
        patient.setPatientName(dto.getPatientName());
        patient.setAge(dto.getAge());
        patient.setDisease(dto.getDisease());
        patient.setContact(dto.getContact());
        patient.setHospital(hospital);

        patient = patientRepo.save(patient);
        dto.setId(patient.getId());
        return dto;
    }

    // ✅ Get All Patients
    public List<PatientDTO> getAll() {
        return patientRepo.findAll().stream().map(p ->
                new PatientDTO(
                        p.getId(),
                        p.getPatientName(),
                        p.getAge(),
                        p.getDisease(),
                        p.getContact(),
                        p.getHospital().getId()
                )
        ).toList();
    }

    // ✅ Update Patient
    public PatientDTO updatePatient(Long id, PatientDTO dto) {
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient ID " + id + " not found."));

        Hospital hospital = hospitalRepo.findById(dto.getHospitalId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Hospital ID " + dto.getHospitalId() + " not found."));

        patient.setPatientName(dto.getPatientName());
        patient.setAge(dto.getAge());
        patient.setDisease(dto.getDisease());
        patient.setContact(dto.getContact());
        patient.setHospital(hospital);

        patientRepo.save(patient);
        dto.setId(patient.getId());
        return dto;
    }

    // ✅ Delete Patient
    public void deletePatient(Long id) {
        if (!patientRepo.existsById(id)) {
            throw new IllegalArgumentException("Patient ID " + id + " not found.");
        }
        patientRepo.deleteById(id);
    }

    public List<PatientDTO> searchPatients(String name, String disease, int page, int size) {
        return patientRepo.searchPatients(name, disease, page, size)
                .stream()
                .map(p -> new PatientDTO(
                        p.getId(),
                        p.getPatientName(),
                        p.getAge(),
                        p.getDisease(),
                        p.getContact(),
                        p.getHospital().getId()
                ))
                .toList();
    }

    }

