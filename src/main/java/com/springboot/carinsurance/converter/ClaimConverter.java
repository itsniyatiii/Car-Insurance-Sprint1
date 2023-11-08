package com.springboot.carinsurance.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.ClaimDTO;
import com.springboot.carinsurance.entity.Claim;


@Component
public class ClaimConverter //creating Admin converter class 
{

	//convert from DTO to Entity
	public Claim convertToClaimEntity(ClaimDTO claimDTO)
	{
		Claim claim=new Claim();
		if(claimDTO!=null)
		{
			BeanUtils.copyProperties(claimDTO, claim);
		}
		return claim;
			
	}
		
		
	//convert from Entity to DTO
	public ClaimDTO convertToClaimDTO(Claim claim)
	{
		ClaimDTO claimDTO=new ClaimDTO();
		if(claim!=null)
		{
			BeanUtils.copyProperties(claim, claimDTO);
		}
		return claimDTO;
		
	}

}
