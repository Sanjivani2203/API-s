package com.example.spring_jpa_relationship.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_jpa_relationship.model.User;
public interface Userrepositriy  extends JpaRepository<User, Long>
{
	
}

