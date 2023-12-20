package com.springboot.carinsurance.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.carinsurance.converter.InsurancePolicyConverter;
import com.springboot.carinsurance.dao.InsurancePolicyRepository;
import com.springboot.carinsurance.dao.UserRepository;
import com.springboot.carinsurance.dto.InsurancePolicyDTO;
import com.springboot.carinsurance.entity.InsurancePolicy;
import com.springboot.carinsurance.entity.User;
import com.springboot.carinsurance.service.InsurancePolicyService;

//Creating  InsurancePolicyServiceImpl class
//Service class implementing Component class
@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService
{

	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private InsurancePolicyConverter insurancePolicyConverter;
	
	//method to create a policy
	public InsurancePolicyDTO createInsurancePolicy(InsurancePolicy insurancePolicy) 
	{
		InsurancePolicy ip=insurancePolicyRepository.save(insurancePolicy);
		return insurancePolicyConverter.convertToInsurancePolicyDTO(ip);
	}
	
	//method to retrieve all the policies
	@Override
	public List<InsurancePolicyDTO> getAllInsurancePolicies()
	{
		List<InsurancePolicy> insurancePolicies=insurancePolicyRepository.findAll();
		
		//list of type DTO
		List<InsurancePolicyDTO> dtoList=new ArrayList<>();
		
		for(InsurancePolicy ip:insurancePolicies)
		{
			dtoList.add(insurancePolicyConverter.convertToInsurancePolicyDTO(ip));
		}
		return dtoList;
	}
	
	//method to retrieve a policy
	@Override
	public InsurancePolicyDTO getInsurancePolicyById(int id)
	{
		InsurancePolicy insurancePolicy=insurancePolicyRepository.findBypolicyId(id);
		return insurancePolicyConverter.convertToInsurancePolicyDTO(insurancePolicy);
	}
	
	
	@Override
	public InsurancePolicy assignUser(int uId, int insId) {
	User u1=userRepository.findByuserId(uId);
	InsurancePolicy p1 = insurancePolicyRepository.findBypolicyId(insId);
	   p1.setUser(u1);	
	  return insurancePolicyRepository.save(p1);
	   
	}
	
	//method to update a policy
	@Override
	public InsurancePolicyDTO updateInsurancePolicy(int id, InsurancePolicy insurancePolicy)
	{
		InsurancePolicy ip=insurancePolicyRepository.findBypolicyId(id);
		ip.setPolicy_no(insurancePolicy.getPolicy_no());
		ip.setPolicy_type(insurancePolicy.getPolicy_type());
		ip.setDuration_in_months(insurancePolicy.getDuration_in_months());
		ip.setPremium_amount(insurancePolicy.getPremium_amount());
		ip.setCoverage_amount(insurancePolicy.getCoverage_amount());
		ip.setDeductible_amount(insurancePolicy.getDeductible_amount());
		ip.setUser(insurancePolicy.getUser());
		
		InsurancePolicy ipp=insurancePolicyRepository.save(ip);
		return insurancePolicyConverter.convertToInsurancePolicyDTO(ipp);
	}
	
	//method to delete a policy
	@Override
	public String deleteInsurancePolicy(int id) 
	{
		insurancePolicyRepository.deleteById(id);
		return "InsurancePolicy got deleted successfully";
	}


	

	
	
}
