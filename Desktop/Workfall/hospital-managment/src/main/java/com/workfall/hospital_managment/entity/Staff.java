package com.workfall.hospital_managment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Staff {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String staffName;
    private String role;   
    private String department;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonBackReference
    private Hospital hospital;
}
