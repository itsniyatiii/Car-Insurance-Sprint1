package com.springboot.carinsurance.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class UserDTO
{

	private int userId;
	
	@NotEmpty(message = "User Name should not be empty")
	private String user_name;
	
	@NotEmpty(message = "Password should not be empty")
	private String user_password;
	
	@NotNull(message="Contact no. should not be null")
	@Size(min=10, max=10)
	private String user_contact_no;
	
	@NotBlank(message="address should not be blank")
	private String user_address;

}
