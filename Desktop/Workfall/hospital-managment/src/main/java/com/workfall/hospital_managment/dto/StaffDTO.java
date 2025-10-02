package com.workfall.hospital_managment.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StaffDTO {
	private Long id;
    private String staffName;
    private String role;
    private String department;
    private double salary;
    private Long hospitalId;
}
