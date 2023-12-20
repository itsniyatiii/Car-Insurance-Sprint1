package com.springboot.carinsurance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.carinsurance.converter.PaymentConverter;
import com.springboot.carinsurance.dto.PaymentDTO;
import com.springboot.carinsurance.entity.Payment;
import com.springboot.carinsurance.service.PaymentService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class PaymentController	//creating Payment controller class
{
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentConverter paymentConverter;
	
	@PostMapping("/createPayment")  //post mapping to create a payment
	public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO )
	{
		final Payment payment=paymentConverter.convertToPaymentEntity(paymentDTO);
		return new ResponseEntity<PaymentDTO>(paymentService.createPayment(payment),HttpStatus.CREATED); 
	 }
	
	@GetMapping("/getAllPayments")  //get mapping to retrieve all the payments
	public List<PaymentDTO> getAllPayments()
	{
		return paymentService.getAllPayments();
	}
	
	@GetMapping("getPaymentById/{id}")  //get mapping retrieve a payment
	public PaymentDTO getPaymentById(@PathVariable int id) 
	{
		return paymentService.getPaymentById(id);
	}
	
	//assign payment to Car
			@PostMapping("/payment/assignCar/{cId}/{pId}")
			public ResponseEntity<Payment> assignCar(@PathVariable("cId") int cId,
						@PathVariable("pId") int pId)
			{
				return new ResponseEntity<Payment>(paymentService.assignCar(cId, pId),
							HttpStatus.CREATED);
			}
	
	@PutMapping("updatePayment/{id}")   //put mapping to update a payment
	public PaymentDTO updatePayment( @PathVariable int id,@RequestBody PaymentDTO paymentDTO)
	{
		final Payment payment=paymentConverter.convertToPaymentEntity(paymentDTO);
		return paymentService.updatePayment(id, payment);
	}
	
	@DeleteMapping("/deletePayment/{id}")  //delete mapping to delete a payment
	public String deletePayment(@PathVariable int id)
	{
		return paymentService.deletePayment(id);
	}
	

}
