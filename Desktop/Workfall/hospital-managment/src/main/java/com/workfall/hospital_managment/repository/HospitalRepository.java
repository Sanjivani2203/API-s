package com.workfall.hospital_managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workfall.hospital_managment.entity.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>,HospitalRepositoryCustom {

}
