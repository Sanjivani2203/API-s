package com.workfall.hospital_managment.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PatientDTO {
	private Long id;
    private String patientName;
    private int age;
    private String disease;
    private String contact;
    private Long hospitalId;
}
