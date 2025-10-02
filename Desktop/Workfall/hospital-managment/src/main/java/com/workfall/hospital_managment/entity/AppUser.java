package com.workfall.hospital_managment.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AppUser {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String password;
	    private String email;
	    private String role;  

	    @OneToOne
	    @JoinColumn(name = "patient_id")
	    private Patient patient;
}
