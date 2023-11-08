package com.springboot.carinsurance.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.springboot.carinsurance.dto.PaymentDTO;
import com.springboot.carinsurance.entity.Payment;


@Component
public class PaymentConverter  //creating Payment converter class
{

	//convert from DTO to Entity
	public Payment convertToPaymentEntity(PaymentDTO paymentDTO)
	{
		Payment payment=new Payment();
		if(paymentDTO!=null)
		{
			BeanUtils.copyProperties(paymentDTO, payment);
		}
		return payment;
			
	}
		
		
	//convert from Entity to DTO
	public PaymentDTO convertToPaymentDTO(Payment payment)
	{
		PaymentDTO paymentDTO=new PaymentDTO();
		if(payment!=null)
		{
			BeanUtils.copyProperties(payment, paymentDTO);
		}
		return paymentDTO;
	}

}
