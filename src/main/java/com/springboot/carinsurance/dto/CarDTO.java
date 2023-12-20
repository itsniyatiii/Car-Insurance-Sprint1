package com.springboot.carinsurance.dto;

import java.time.LocalDate;

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
	
	@NotNull(message = "VIN should not be null")   
	private String VIN;
	
	@NotEmpty(message = "car make should not be empty")   
	private String car_make;
	
	@NotEmpty(message = "car model should not be empty")   
	private String car_model;
	
	@NotEmpty(message = "Date should not be empty")
	private String car_manufacturing_year;
	
	@NotEmpty(message = "registration no should not be empty")  
	private String car_registration_no;
	
	@NotNull(message="issued date should not be null")
	private LocalDate policy_issued_date;
	
	@NotNull(message="end date should not be null")
	private LocalDate policy_end_date;
	
	private InsurancePolicy policy;
	
	
}
