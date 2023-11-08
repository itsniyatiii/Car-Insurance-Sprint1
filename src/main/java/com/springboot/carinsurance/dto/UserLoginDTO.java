package com.springboot.carinsurance.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class UserLoginDTO {

	private int id;
	private String username;
	private String password;
	

}
