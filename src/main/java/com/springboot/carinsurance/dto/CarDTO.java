package com.springboot.carinsurance.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.springboot.carinsurance.entity.InsurancePolicy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class CarDTO 
{
	private int carId;
	
	@NotBlank(message = "VIN should not be blank")   
	private String VIN;
	
	@NotEmpty(message = "car make should not be empty")   
	private String car_make;
	
	@NotEmpty(message = "car model should not be empty")   
	private String car_model;
	
	@NotNull(message = "Date should not be null. The expected format is yyyy-MM-dd")
	private LocalDate car_manufacturing_year;
	
	@NotEmpty(message = "registration no should not be empty")  
	private String car_registration_no;
	private InsurancePolicy policy;
	
}
