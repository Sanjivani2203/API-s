package com.workfall.hospital_managment.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AppUserDTO 
{
	 private Long id;
	    private String username;
	    private String password;
	    private String email;
	    private String role;
	    private Long patientId;
}
