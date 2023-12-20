package com.springboot.carinsurance.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.carinsurance.converter.PaymentConverter;
import com.springboot.carinsurance.dao.CarRepository;
import com.springboot.carinsurance.dao.PaymentRepository;
import com.springboot.carinsurance.dto.PaymentDTO;
import com.springboot.carinsurance.entity.Car;
import com.springboot.carinsurance.entity.Payment;
import com.springboot.carinsurance.service.PaymentService;

//Creating  PaymentServiceImpl class
//Service class implementing Component class
@Service
public class PaymentServiceImpl implements PaymentService 
{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private PaymentConverter paymentConverter;
	
	//method to create a payment
	public PaymentDTO createPayment(Payment payment)
	{
		Payment p=paymentRepository.save(payment);
		return paymentConverter.convertToPaymentDTO(p);
	}
	
	//method to retrieve all the payments
	@Override
	public List<PaymentDTO> getAllPayments()
	{
		List<Payment> payments=paymentRepository.findAll();
		
		//list of type DTO
		List<PaymentDTO> dtoList=new ArrayList<>();
		
		for(Payment p:payments)
		{
			dtoList.add(paymentConverter.convertToPaymentDTO(p));
		}
		return dtoList;
	}
	
	//method to retrieve a payment
	@Override
	public PaymentDTO getPaymentById(int id)
	{
		Payment payment=paymentRepository.findBypaymentId(id);
		return paymentConverter.convertToPaymentDTO(payment);
	}
	
	@Override
	public Payment assignCar(int cId, int pId) {
	Car	c1=carRepository.findBycarId(cId);
	   Payment p1 = paymentRepository.findBypaymentId(pId);
	   p1.setCar(c1);	
	  return paymentRepository.save(p1);
	    
	}

		
	//method to update a payment
	@Override
	public PaymentDTO updatePayment(int id, Payment payment)
	{
		Payment p=paymentRepository.findBypaymentId(id);
		p.setPayment_amount(payment.getPayment_amount());
		p.setPayment_date(payment.getPayment_date());
		p.setCar(payment.getCar());
		
		Payment pp=paymentRepository.save(p);
		return paymentConverter.convertToPaymentDTO(pp);
	}
	
	//method to delete a payment
	@Override
	public String deletePayment(int id)
	{
		paymentRepository.deleteById(id);
		return "Payment got deleted successfully";
	}


	


}
