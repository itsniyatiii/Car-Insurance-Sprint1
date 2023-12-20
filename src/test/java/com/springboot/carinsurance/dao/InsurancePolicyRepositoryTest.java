package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    	insurancePolicy.setDuration_in_months(6);;
    	insurancePolicy.setPremium_amount(2300000);
    	insurancePolicy.setCoverage_amount(2345);
    	insurancePolicy.setDeductible_amount(3400);


    	InsurancePolicy savedInsurancePolicy = insurancePolicyRepository.save(insurancePolicy);
        assertNotNull(savedInsurancePolicy.getPolicyId());
        System.out.println("testCreateInsurancePolicy is running!");
    }
    
    
   
    @Test
    public void testGetInsurancePolicyById() {
        // Create and save an InsurancePolicy
    	InsurancePolicy insurancePolicy = new InsurancePolicy();
    	insurancePolicy.setPolicy_no("45676545674");
    	insurancePolicy.setPolicy_type("collision");
    	insurancePolicy.setDuration_in_months(6);
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
        assertEquals("collision", retrievedInsurancePolicy.getPolicy_type());
        assertEquals(6, retrievedInsurancePolicy.getDuration_in_months());
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
    	insurancePolicy.setDuration_in_months(6);
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
        updatedInsurancePolicy.setPolicy_type("Comprehensive"); // Update password
        updatedInsurancePolicy.setDuration_in_months(12);
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
        assertEquals("Comprehensive", retrievedInsurancePolicy.getPolicy_type());
        assertEquals(12, retrievedInsurancePolicy.getDuration_in_months());
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
    	insurancePolicy.setDuration_in_months(6);
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
