package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.carinsurance.entity.InsurancePolicy;
@SpringBootTest
public class InsurancePolicyRepositoryTest {

	@Autowired
    private InsurancePolicyRepository insurancePolicyRepository;
 
    
    @Test
    public void testCreateInsurancePolicy() {
    	 // Create and save an InsurancePolicy
    	InsurancePolicy insurancePolicy = new InsurancePolicy();
    	insurancePolicy.setPolicy_no("45676545674");
    	insurancePolicy.setPolicy_type("Comprehensive");
    	insurancePolicy.setStart_date(LocalDate.now());
    	insurancePolicy.setEnd_date(LocalDate.of(2024, 11, 5));
    	insurancePolicy.setPremium_amount(2300000);
    	insurancePolicy.setCoverage_amount(2345);
    	insurancePolicy.setDeductible_amount(3400);


    	InsurancePolicy savedInsurancePolicy = insurancePolicyRepository.save(insurancePolicy);
        assertNotNull(savedInsurancePolicy.getPolicyId());
        System.out.println("testCreateInsurancePolicy is running!");
    }
    
    
   // @Test
    public void testGetAllInsurancePolicies()
    {
    	insurancePolicyRepository.deleteAll();
    	
    	//create and save multiple InsurancePolicies entities
    	InsurancePolicy policy1=new InsurancePolicy(1,"12344456789","Comprehensive",LocalDate.now(),LocalDate.of(2024, 10, 5),1200000,1245,3400, null);
    	InsurancePolicy policy2=new InsurancePolicy(2,"22224456789","Liability",LocalDate.now(),LocalDate.of(2024, 10, 6),3400000,8245,8400, null);
    	InsurancePolicy policy3=new InsurancePolicy(1,"34456356789","Collision",LocalDate.now(),LocalDate.of(2024, 10, 7),3200000,5545,5400, null);
    	
    	insurancePolicyRepository.save(policy1);
    	insurancePolicyRepository.save(policy2);
    	insurancePolicyRepository.save(policy3);
    	
    	//retrieve all InsurancePolicies from the databases
    	List<InsurancePolicy> allInsurancePolicies=insurancePolicyRepository.findAll();
    	
    	//assert that the list is not empty and contains the excepted number of InsurancePolicies
    	assertNotNull(allInsurancePolicies);
    	assertEquals(3,allInsurancePolicies.size());
    	
    }
    
    @Test
    public void testGetInsurancePolicyById() {
        // Create and save an InsurancePolicy
    	InsurancePolicy insurancePolicy = new InsurancePolicy();
    	insurancePolicy.setPolicy_no("45676545674");
    	insurancePolicy.setPolicy_type("hgf");
    	insurancePolicy.setStart_date(LocalDate.now());
    	insurancePolicy.setEnd_date(LocalDate.of(2024, 10, 5));
    	insurancePolicy.setPremium_amount(2300000);
    	insurancePolicy.setCoverage_amount(2345);
    	insurancePolicy.setDeductible_amount(3400);
    	insurancePolicy = insurancePolicyRepository.save(insurancePolicy);

        // Retrieve the InsurancePolicy by ID
    	InsurancePolicy retrievedInsurancePolicy = insurancePolicyRepository.findById(insurancePolicy.getPolicyId()).orElse(null);

        // Assert that the retrieved InsurancePolicy is not null and has the correct ID
        assertNotNull(retrievedInsurancePolicy);
        assertEquals(insurancePolicy.getPolicyId(), retrievedInsurancePolicy.getPolicyId());
        assertEquals("45676545674", retrievedInsurancePolicy.getPolicy_no());
        assertEquals("hgf", retrievedInsurancePolicy.getPolicy_type());
        assertEquals(LocalDate.now(), retrievedInsurancePolicy.getStart_date());
        assertEquals(LocalDate.of(2024, 10, 5), retrievedInsurancePolicy.getEnd_date());
        assertEquals(2300000, retrievedInsurancePolicy.getPremium_amount()); 
        assertEquals(2345, retrievedInsurancePolicy.getCoverage_amount());
        assertEquals(3400, retrievedInsurancePolicy.getDeductible_amount());
        System.out.println("testGetInsurancePolicyById is running!");
    }

    
    
    @Test
    public void testUpdateInsurancePolicyById() {
        // Create and save an InsurancePolicy
    	InsurancePolicy insurancePolicy = new InsurancePolicy();
    	insurancePolicy.setPolicy_no("45676545674");
    	insurancePolicy.setPolicy_type("hgf");
    	insurancePolicy.setStart_date(LocalDate.now());
    	insurancePolicy.setEnd_date(LocalDate.of(2024, 11, 5));
    	insurancePolicy.setPremium_amount(2300000);
    	insurancePolicy.setCoverage_amount(2345);
    	insurancePolicy.setDeductible_amount(3400);
    	insurancePolicy = insurancePolicyRepository.save(insurancePolicy);

        // Update the admin's details
        int insurancePolicyId = insurancePolicy.getPolicyId();
        InsurancePolicy updatedInsurancePolicy = insurancePolicyRepository.findById(insurancePolicyId).orElse(null);
        assertNotNull(updatedInsurancePolicy);

        // Modify the admin's attributes
        updatedInsurancePolicy.setPolicy_no("999999997"); // Update username
        updatedInsurancePolicy.setPolicy_type("abc"); // Update password
        updatedInsurancePolicy.setStart_date(LocalDate.now());
        updatedInsurancePolicy.setEnd_date(LocalDate.of(2024, 11, 5));
        updatedInsurancePolicy.setPremium_amount(2000000);
        updatedInsurancePolicy.setCoverage_amount(5555);
        updatedInsurancePolicy.setDeductible_amount(2000);// Update email

        // Save the updated insurancePolicy
        updatedInsurancePolicy = insurancePolicyRepository.save(updatedInsurancePolicy);

        // Retrieve the updated insurancePolicy from the database
        InsurancePolicy retrievedInsurancePolicy = insurancePolicyRepository.findById(insurancePolicyId).orElse(null);
        assertNotNull(retrievedInsurancePolicy);

        // Assert that the attributes have been updated
        assertEquals("999999997", retrievedInsurancePolicy.getPolicy_no());
        assertEquals("abc", retrievedInsurancePolicy.getPolicy_type());
        assertEquals(LocalDate.now(), retrievedInsurancePolicy.getStart_date());
        assertEquals(LocalDate.of(2024, 11, 5), retrievedInsurancePolicy.getEnd_date());
        assertEquals(2000000, retrievedInsurancePolicy.getPremium_amount());
        assertEquals(5555, retrievedInsurancePolicy.getCoverage_amount());
        assertEquals(2000, retrievedInsurancePolicy.getDeductible_amount());
        System.out.println("testUpdateInsurancePolicyById is running!");
       
    }


    
    
    @Test
    public void testDeleteInsurancePolicyById() {
        // Create and save an InsurancePolicy
    	InsurancePolicy insurancePolicy = new InsurancePolicy();
    	insurancePolicy.setPolicy_no("45676545674");
    	insurancePolicy.setPolicy_type("hgf");
    	insurancePolicy.setStart_date(LocalDate.now());
    	insurancePolicy.setEnd_date(LocalDate.of(2024, 10, 5));
    	insurancePolicy.setPremium_amount(2300000);
    	insurancePolicy.setCoverage_amount(2345);
    	insurancePolicy.setDeductible_amount(3400);
    	insurancePolicy = insurancePolicyRepository.save(insurancePolicy);

        // Get the ID of the InsurancePolicy to be deleted
        int insurancePolicyId = insurancePolicy.getPolicyId();

        // Delete the InsurancePolicy by ID
        insurancePolicyRepository.deleteById(insurancePolicyId);

        // Try to retrieve the deleted InsurancePolicy by ID, and it should be null
        InsurancePolicy deletedInsurancePolicy = insurancePolicyRepository.findById(insurancePolicyId).orElse(null);
        assertNull(deletedInsurancePolicy);
        System.out.println("testDeleteInsurancePolicyById is running!");
    }



}
