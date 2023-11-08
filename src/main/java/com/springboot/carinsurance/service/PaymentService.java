package com.springboot.carinsurance.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.PaymentDTO;
import com.springboot.carinsurance.entity.Payment;


@Component
public interface PaymentService //Creating Payment service interface
{

	public PaymentDTO createPayment(Payment payment); //method to create a payment

	public List<PaymentDTO> getAllPayments();  //method to retrieve all the payments

	public PaymentDTO getPaymentById(int id); //method to retrieve a payment

	public PaymentDTO updatePayment(int id, Payment payment); //method to update a payment

	public String deletePayment(int id); //method to delete a payment

}
