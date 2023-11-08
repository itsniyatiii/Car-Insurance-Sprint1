package com.springboot.carinsurance.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class AdminDTO
{

	private int adminId;
	
	@NotEmpty(message = "UserName should not be empty")   
	private String admin_name;
	
	@NotEmpty(message = "Password should not be empty")
	private String admin_password;
	
	@Email(message= "Enter proper Email")
	private String admin_email_address;
	
	@NotNull(message="Contact no. should not be null")
	@Size(min=10, max=10)
	private String admin_contact_no;
	
}
