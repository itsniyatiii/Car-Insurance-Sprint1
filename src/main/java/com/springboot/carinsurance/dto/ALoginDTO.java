package com.springboot.carinsurance.dto;

import lombok.Data;

@Data
public class ALoginDTO {


	private String adminEmail;
	private String adminPassword;
	
	public ALoginDTO() {
	}
	public ALoginDTO(String adminEmail, String adminPassword) {
	this.adminEmail = adminEmail;
	this.adminPassword = adminPassword;
	}
}
