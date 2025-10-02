package com.workfall.hospital_managment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private int age;
    private String disease;
    private String contact;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonBackReference
    private Hospital hospital;
}
