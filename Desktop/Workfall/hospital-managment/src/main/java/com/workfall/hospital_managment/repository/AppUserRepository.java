package com.workfall.hospital_managment.repository;

import com.workfall.hospital_managment.entity.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long>,AppUserRepositoryCustom  {}

