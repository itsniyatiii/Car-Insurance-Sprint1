package com.springboot.carinsurance.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	
	@NotEmpty(message="First name should not be empty")
	private String userFirstName;							//Data members
	
	@NotEmpty(message="Last name should not be empty")
	private String userLastName;
	
	@NotNull(message="Aadhar should not be null")
	@Size(min=12, max=12)
	private String userAadhar;
	
	@Min(value = 18, message = "Age must be greater than 18")
	@Max(value = 100, message = "Age must not be greater than 100")
	private int userAge;
	
	@NotEmpty(message="City should not be empty")
	private String userCity;
	
	@NotNull(message="Mobile should not be null")
	@Size(min=10, max=10)
	private String userMobile;
	
	@Email(message="Enter valid email")
	private String userEmail;
	
	@NotEmpty(message = "Username should not be empty")
	private String userUserName;
	
	@NotEmpty(message = "Password should not be empty")
	private String userPassword;
	

}
