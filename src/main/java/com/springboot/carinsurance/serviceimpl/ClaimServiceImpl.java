package com.springboot.carinsurance.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.carinsurance.converter.ClaimConverter;
import com.springboot.carinsurance.dao.ClaimRepository;
import com.springboot.carinsurance.dao.InsurancePolicyRepository;
import com.springboot.carinsurance.dto.ClaimDTO;
import com.springboot.carinsurance.entity.Claim;
import com.springboot.carinsurance.entity.InsurancePolicy;
import com.springboot.carinsurance.service.ClaimService;

//Creating ClaimServiceImpl class
//Service class implementing Component class
@Service
public class ClaimServiceImpl implements ClaimService 
{

	@Autowired
	private ClaimRepository claimRepository;
	
	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	
	@Autowired
	private ClaimConverter claimConverter;
	
	//method to create a claim
	public ClaimDTO createClaim(Claim claim)
	{
		Claim c=claimRepository.save(claim);
		return claimConverter.convertToClaimDTO(c);
	}
	
	//method to retrieve all the claims
	@Override
	public List<ClaimDTO> getAllClaims() 
	{
		List<Claim> claims=claimRepository.findAll();
		
		//list of type DTO
		List<ClaimDTO> dtoList=new ArrayList<>();
		
		for(Claim c:claims)
		{
			dtoList.add(claimConverter.convertToClaimDTO(c));
		}
		return dtoList;
	}
	
	//method to retrieve a claim
	@Override
	public ClaimDTO getClaimById(int id)
	{
		Claim claim=claimRepository.findByclaimId(id);
		return claimConverter.convertToClaimDTO(claim);
	}
	
	@Override
	public Claim assignInsurancePolicy(int insId, int cId) {
	InsurancePolicy	ins1=insurancePolicyRepository.findBypolicyId(insId);
	   Claim c1 = claimRepository.findByclaimId(cId);
	   c1.setPolicy(ins1);	
	  return claimRepository.save(c1);
	    //return converter.convertToCourseDTO(c1);
	}

	
	
	//method to update a claim
	@Override
	public ClaimDTO updateClaim(int id, Claim claim) 
	{ 
		Claim c=claimRepository.findByclaimId(id);
		c.setVIN(claim.getVIN());
		c.setClaim_no(claim.getClaim_no());
		c.setClaim_amount(claim.getClaim_amount());
		c.setStatus(claim.getStatus());
		c.setIssued_date(claim.getIssued_date());
		c.setPolicy(claim.getPolicy());
		
		Claim cc=claimRepository.save(c);
		return claimConverter.convertToClaimDTO(cc);
	}
	
	//method to delete a claim
	@Override
	public String deleteClaim(int id) 
	{
		claimRepository.deleteById(id);
		return "Claims got deleted successfully";
	}

}
