package com.springboot.carinsurance.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.InsurancePolicyDTO;
import com.springboot.carinsurance.entity.InsurancePolicy;


@Component
public interface InsurancePolicyService //Creating InsurancePolicy service interface
{

	//method to create a policy
	public InsurancePolicyDTO createInsurancePolicy(InsurancePolicy insurancePolicy); 

	//method to retrieve all the policies
	public List<InsurancePolicyDTO> getAllInsurancePolicies();

	//method to retrieve a policy
	public InsurancePolicyDTO getInsurancePolicyById(int id);

	//method to update a policy
	public InsurancePolicyDTO updateInsurancePolicy(int id, InsurancePolicy insurancePolicy);

	//method to delete a policy
	public String deleteInsurancePolicy(int id);

}
