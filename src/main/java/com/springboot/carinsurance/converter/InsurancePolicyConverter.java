package com.springboot.carinsurance.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.InsurancePolicyDTO;
import com.springboot.carinsurance.entity.InsurancePolicy;


@Component
public class InsurancePolicyConverter //creating InsurancePolicy converter class
{
	//convert from DTO to Entity
	public InsurancePolicy convertToInsurancePolicyEntity(InsurancePolicyDTO insurancePolicyDTO)
	{
		InsurancePolicy insurancePolicy=new InsurancePolicy();
		if(insurancePolicyDTO!=null)
		{
			BeanUtils.copyProperties(insurancePolicyDTO, insurancePolicy);
		}
		return insurancePolicy;
				
	}
			
			
	//convert from Entity to DTO
	public InsurancePolicyDTO convertToInsurancePolicyDTO(InsurancePolicy insurancePolicy)
	{
		InsurancePolicyDTO insurancePolicyDTO=new InsurancePolicyDTO();
		if(insurancePolicy!=null)
		{
			BeanUtils.copyProperties(insurancePolicy, insurancePolicyDTO);
		}
		return insurancePolicyDTO;
	}


}
