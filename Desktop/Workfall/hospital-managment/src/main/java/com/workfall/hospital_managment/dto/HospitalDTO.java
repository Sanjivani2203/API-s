package com.workfall.hospital_managment.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HospitalDTO {
	 private Long id;
	    private String name;
	    private String address;
	    private String contactNumber;
	    private String type;
}
