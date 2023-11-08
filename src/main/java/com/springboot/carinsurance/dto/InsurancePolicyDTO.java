package com.springboot.carinsurance.dto;


import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.springboot.carinsurance.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class InsurancePolicyDTO
{
	
	private int policyId;
	
	@NotEmpty(message = "policy no should not be empty") 
	private String policy_no;
	
	@NotBlank(message = "policy type should not be blank")  
	private String policy_type;
	
	@NotNull(message = "Date should not be null. The expected format is yyyy-MM-dd")
	private LocalDate start_date;
	
	@NotNull(message = "Date should not be null. The expected format is yyyy-MM-dd")
	private LocalDate end_date;
	
	@NotNull(message="amount should not be null")
	private double premium_amount;
	
	@NotNull(message="amount should not be null")
	private double coverage_amount;
	
	@NotNull(message="amount should not be null")
	private double deductible_amount;
	private User user;
	
}
