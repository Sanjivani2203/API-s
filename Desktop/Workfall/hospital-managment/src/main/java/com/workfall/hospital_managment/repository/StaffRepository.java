package com.workfall.hospital_managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workfall.hospital_managment.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>,StaffRepositoryCustom  {

}
