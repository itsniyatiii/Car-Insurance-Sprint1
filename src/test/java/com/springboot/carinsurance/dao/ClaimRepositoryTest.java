package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.carinsurance.entity.Claim;
@SpringBootTest
public class ClaimRepositoryTest {

	@Autowired
    private ClaimRepository claimRepository;
 
    
    @Test
    public void testCreateClaim()
    {
    	 // Create and save an claim
    	Claim claim = new Claim();
        claim.setClaim_no("12344646");
        claim.setClaim_amount(2345.4);
        claim.setStatus("Approved");
        claim.setIssued_date(LocalDate.now());

        Claim savedClaim = claimRepository.save(claim);
        assertNotNull(savedClaim.getClaimId());
        System.out.println("testCreateClaim is running!");
    }
    
    @Test
    public void testGetAllClaims()
    {
    	claimRepository.deleteAll();
    	
    	//create and save multiple car entities
    	Claim claim1=new Claim(1,"123456789",2344.4,"Approved",LocalDate.now(),null);
    	Claim claim2=new Claim(2,"987654321",2000.00,"Approved",LocalDate.now(),null);
    	Claim claim3=new Claim(3,"223344556",3400.00,"Approved",LocalDate.now(),null);
    	
    	claimRepository.save(claim1);
    	claimRepository.save(claim2);
    	claimRepository.save(claim3);
    	
    	//retrieve all claims from the databases
    	List<Claim> allClaims=claimRepository.findAll();
    	
    	//assert that the list is not empty and contains the excepted number of claims
    	assertNotNull(allClaims);
    	assertEquals(3,allClaims.size());
    }
    
    
    @Test
    public void testGetClaimById() {
        // Create and save an claim
        Claim claim = new Claim();
        claim.setClaim_no("12344643");
        claim.setClaim_amount(2344.55);
        claim.setStatus("Approved");
        claim.setIssued_date(LocalDate.now());

        claim = claimRepository.save(claim);
        

        // Retrieve the claim by ID
        Claim retrievedClaim = claimRepository.findById(claim.getClaimId()).orElse(null);

        // Assert that the retrieved claim is not null and has the correct ID
        assertNotNull(retrievedClaim);
        assertEquals(claim.getClaimId(), retrievedClaim.getClaimId());
        assertEquals("12344643", retrievedClaim.getClaim_no());
        assertEquals(2344.55, retrievedClaim.getClaim_amount());
        assertEquals("Approved", retrievedClaim.getStatus());
        assertEquals((LocalDate.now()), retrievedClaim.getIssued_date());
        System.out.println("testGetClaimById is running!");
    }   
    
    @Test
    public void testUpdateClaimById() {
        // Create and save an claim
        Claim claim = new Claim();
        claim.setClaim_no("12456789");
        claim.setClaim_amount(1123.45);
        claim.setStatus("Approved");
        claim.setIssued_date((LocalDate.now()));
        claim = claimRepository.save(claim);

        // Update the claim's details
        int claimId = claim.getClaimId();
        Claim updatedClaim = claimRepository.findById(claimId).orElse(null);
        assertNotNull(updatedClaim);

        // Modify the claim's attributes
        updatedClaim.setClaim_no("1232123");;
        updatedClaim.setClaim_amount(2323.23);
        updatedClaim.setStatus("Approved"); 
        updatedClaim.setIssued_date((LocalDate.now())); 
        
        // Save the updated claim
        updatedClaim = claimRepository.save(updatedClaim);

        // Retrieve the updated claim from the database
        Claim retrievedClaim = claimRepository.findById(claimId).orElse(null);
        assertNotNull(retrievedClaim);

        // Assert that the attributes have been updated
        assertEquals("1232123", retrievedClaim.getClaim_no());
        assertEquals(2323.23, retrievedClaim.getClaim_amount());
        assertEquals("Approved", retrievedClaim.getStatus());
        assertEquals((LocalDate.now()), retrievedClaim.getIssued_date());
        System.out.println("testUpdateClaimById is running!");
    }
 
    
    @Test
    public void testDeleteClaimById() {
        // Create and save an claim
    	Claim claim = new Claim();
    	claim.setClaim_no("124567444");
    	claim.setClaim_amount(1122.22);
    	claim.setStatus("Approved");
    	claim.setIssued_date((LocalDate.now()));
    	claim = claimRepository.save(claim);
       

        // Get the ID of the claim to be deleted
        int claimId = claim.getClaimId();

        // Delete the claim by ID
        claimRepository.deleteById(claimId);

        // Try to retrieve the deleted claim by ID, and it should be null
        Claim deletedClaim = claimRepository.findById(claimId).orElse(null);
        assertNull(deletedClaim);
        System.out.println("testDeleteClaimById is running!");
    }



}
