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

import com.springboot.carinsurance.converter.ClaimConverter;
import com.springboot.carinsurance.dto.ClaimDTO;
import com.springboot.carinsurance.entity.Claim;
import com.springboot.carinsurance.service.ClaimService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class ClaimController	//creating Claim controller class
{
	@Autowired
	private ClaimService claimService;
	
	@Autowired
	private ClaimConverter claimConverter;
	
	@PostMapping("/createClaim")  //post mapping to create a claim
	public ResponseEntity<ClaimDTO> createClaim(@RequestBody ClaimDTO claimDTO )
	{
		final Claim claim=claimConverter.convertToClaimEntity(claimDTO);
		return new ResponseEntity<ClaimDTO>(claimService.createClaim(claim),HttpStatus.CREATED); 
	 }
	
	
	@GetMapping("/getAllClaims") //get mapping to retrieve all the claims
	public List<ClaimDTO> getAllClaims()
	{
		return claimService.getAllClaims();
	}
	
	@GetMapping("getClaimById/{id}")  //get mapping retrieve a claim
	public ClaimDTO getClaimById(@PathVariable int id) 
	{
		return claimService.getClaimById(id);
	}
	
	//assign claim to insurancepolicy
		@PostMapping("/claim/assignInsurancePolicy/{insId}/{cId}")
		public ResponseEntity<Claim> assignInsurancePolicy(@PathVariable("insId") int insId,
					@PathVariable("cId") int cId)
		{
			return new ResponseEntity<Claim>(claimService.assignInsurancePolicy(insId, cId),
						HttpStatus.CREATED);
		}
	
			
	@PutMapping("updateClaim/{id}")   //put mapping to update a claim
	public ClaimDTO updateClaim( @PathVariable int id,@RequestBody ClaimDTO claimDTO)
	{
		final Claim claim=claimConverter.convertToClaimEntity(claimDTO);
		return claimService.updateClaim(id, claim);
	}
	
	@DeleteMapping("/deleteClaim/{id}")  //delete mapping to delete a claim
	public String deleteClaim(@PathVariable int id)
	{
		return claimService.deleteClaim(id);
	}
	

}
