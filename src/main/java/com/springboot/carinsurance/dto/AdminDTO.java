package com.springboot.carinsurance.dto;


import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class AdminDTO
{

	private int adminId;
	
	@NotEmpty(message = "Email should not be empty")   
	private String adminEmail;
	
	@NotEmpty(message = "Password should not be empty")
	private String adminPassword;
	
}
