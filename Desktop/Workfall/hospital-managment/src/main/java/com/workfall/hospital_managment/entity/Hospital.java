package com.workfall.hospital_managment.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Hospital {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String address;
	    private String contactNumber;
	    private String type;

	    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Staff> staffList = new ArrayList<>();
	    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Patient> patientList = new ArrayList<>();
	}


