package com.springboot.carinsurance.dto;

import lombok.Data;

@Data
public class LoginDTO {

	private String userEmail;
	private String userPassword;
	
	public LoginDTO() {
	}
	public LoginDTO(String userEmail, String userPassword) {
	this.userEmail = userEmail;
	this.userPassword = userPassword;
	}
}
