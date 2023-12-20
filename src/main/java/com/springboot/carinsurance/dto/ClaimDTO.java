package com.springboot.carinsurance.dto;


import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.springboot.carinsurance.entity.InsurancePolicy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class ClaimDTO 
{
	private int claimId;
	
	@NotNull(message = "VIN should not be null") 
	private String VIN;
	
	@NotEmpty(message = "claim no should not be empty")  
	private String claim_no;
	
	@NotNull(message="amount should not be null")
	private double claim_amount;
	
	@NotBlank(message="status should not be blank")
	private String status;
	
	@NotNull(message = "Date should not be null. The expected format is yyyy-MM-dd")
	private LocalDate issued_date;
	private InsurancePolicy policy;
	
}
