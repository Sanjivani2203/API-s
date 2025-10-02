package com.workfall.hospital_managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workfall.hospital_managment.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>,PatientRepositoryCustom {

}
