package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.carinsurance.entity.Payment;
@SpringBootTest
public class PaymentRepositoryTest {

	 @Autowired
	    private PaymentRepository paymentRepository;
	 
	    
	    @Test
	    public void testCreatePayment() {
	    	 // Create and save an payment
	        Payment payment = new Payment();
	        payment.setPayment_amount(1200.09);
	        payment.setPayment_date(LocalDate.now());

	        Payment savedPayment= paymentRepository.save(payment);
	        assertNotNull(savedPayment.getPaymentId());
	        System.out.println("testCreatePayment is running!");
	    }
	    
	    @Test
	    public void testGetAllPayments()
	    {
	    	paymentRepository.deleteAll();
	    	
	    	//create and save multiple payment entities
	    	Payment payment1=new Payment(1,1300.00,LocalDate.now(),null);
	    	Payment payment2=new Payment(2,2000.00,LocalDate.now(),null);
	    	Payment payment3=new Payment(3,1400.00,LocalDate.now(),null);
	    	
	    	paymentRepository.save(payment1);
	    	paymentRepository.save(payment2);
	    	paymentRepository.save(payment3);
	    	
	    	//retrieve all payments from the databases
	    	List<Payment> allPayments=paymentRepository.findAll();
	    	
	    	//assert that the list is not empty and contains the excepted number of payments
	    	assertNotNull(allPayments);
	    	assertEquals(3,allPayments.size());
	    }
	    
	    @Test
	    public void testGetPaymentById() {
	        // Create and save an payment
	        Payment payment = new Payment();
	        payment.setPayment_amount(1200.09);
	        payment.setPayment_date(LocalDate.now());

	        payment = paymentRepository.save(payment);

	        // Retrieve the payment by ID
	        Payment retrievedPayment = paymentRepository.findById(payment.getPaymentId()).orElse(null);

	        // Assert that the retrieved payment is not null and has the correct ID
	        assertNotNull(retrievedPayment);
	        assertEquals(payment.getPaymentId(), retrievedPayment.getPaymentId());
	        assertEquals(1200.09, retrievedPayment.getPayment_amount());
	        assertEquals(LocalDate.now(), retrievedPayment.getPayment_date());
	        
	        System.out.println("testGetPaymentById is running!");
	    }
	
	    	    
	    @Test
	    public void testUpdatePaymentById() {
	        // Create and save an payment
	        Payment payment = new Payment();
	        payment.setPayment_amount(1200.09);
	        payment.setPayment_date(LocalDate.now());
	        payment = paymentRepository.save(payment);

	        // Update the admin's details
	        int paymentId = payment.getPaymentId();
	        Payment updatedPayment = paymentRepository.findById(paymentId).orElse(null);
	        assertNotNull(updatedPayment);

	        // Modify the payment's attributes
	        updatedPayment.setPayment_amount(2000.22); // Update username
	        updatedPayment.setPayment_date(LocalDate.now()); // Update password
	       

	        // Save the updated payment
	        updatedPayment = paymentRepository.save(updatedPayment);

	        // Retrieve the updated payment from the database
	        Payment retrievedPayment = paymentRepository.findById(paymentId).orElse(null);
	        assertNotNull(retrievedPayment);

	        // Assert that the attributes have been updated
	        assertEquals(2000.22, retrievedPayment.getPayment_amount());
	        assertEquals(LocalDate.now(), retrievedPayment.getPayment_date());
	       
	        System.out.println("testUpdatePaymentById is running!");
	       
	    }

	    
	    @Test
	    public void testDeletePaymentById() {
	        // Create and save an payment
	    	Payment payment = new Payment();
	        payment.setPayment_amount(1200.09);
	        payment.setPayment_date(LocalDate.now());
	        payment = paymentRepository.save(payment);


	        // Get the ID of the payment to be deleted
	        int paymentId = payment.getPaymentId();

	        // Delete the payment by ID
	        paymentRepository.deleteById(paymentId);

	        // Try to retrieve the deleted payment by ID, and it should be null
	        Payment deletedPayment = paymentRepository.findById(paymentId).orElse(null);
	        assertNull(deletedPayment);
	        System.out.println("testDeletePaymentById is running!");
	    }

}

