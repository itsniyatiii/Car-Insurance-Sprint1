package com.springboot.carinsurance.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.ClaimDTO;
import com.springboot.carinsurance.entity.Claim;


@Component
public interface ClaimService  //Creating Claim service interface
{
	public ClaimDTO createClaim(Claim claim); //method to create a claim

	public List<ClaimDTO> getAllClaims(); //method to retrieve all the claims

	public ClaimDTO getClaimById(int id);  //method to retrieve a claim
	
	public ClaimDTO updateClaim(int id, Claim claim);  //method to update a claim

	public String deleteClaim(int id);  //method to delete a claim

	
	
}
