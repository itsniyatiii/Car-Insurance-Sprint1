package com.springboot.carinsurance.dto;


import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.springboot.carinsurance.entity.InsurancePolicy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class PaymentDTO
{

	private int paymentId;
	
	@NotNull(message="amount should not be null")
	private double payment_amount;
	
	@NotNull(message = "Date should not be null. The expected format is yyyy-MM-dd")
	private LocalDate payment_date;
	private InsurancePolicy policy;

}
