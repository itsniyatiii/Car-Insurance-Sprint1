package com.springboot.carinsurance.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class DemoDTO {

	private int id;
	private String username;
	private String password;
	

}
