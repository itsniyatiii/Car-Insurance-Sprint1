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
import com.springboot.carinsurance.converter.InsurancePolicyConverter;
import com.springboot.carinsurance.dto.InsurancePolicyDTO;
import com.springboot.carinsurance.entity.InsurancePolicy;
import com.springboot.carinsurance.service.InsurancePolicyService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class InsurancePolicyController	//creating InsurancePolicy controller class
{

	@Autowired
	private InsurancePolicyService insurancePolicyService;
	
	@Autowired
	private InsurancePolicyConverter insurancePolicyConverter;
	
	@PostMapping("/createPolicy")  //post mapping to create a policy
	public ResponseEntity<InsurancePolicyDTO> createInsurancePolicy(@RequestBody InsurancePolicyDTO insurancePolicyDTO )
	{
		final InsurancePolicy insurancePolicy=insurancePolicyConverter.convertToInsurancePolicyEntity(insurancePolicyDTO);
		return new ResponseEntity<InsurancePolicyDTO>(insurancePolicyService.createInsurancePolicy(insurancePolicy),HttpStatus.CREATED); 
	 }
	
	@GetMapping("/getAllPolicies")  //get mapping to retrieve all the policies
	public List<InsurancePolicyDTO> getAllInsurancePolicies()
	{
		return insurancePolicyService.getAllInsurancePolicies();
	}
	
	@GetMapping("getPolicyById/{id}")  //get mapping retrieve a policy
	public InsurancePolicyDTO getInsurancePolicyById(@PathVariable int id) 
	{
		return insurancePolicyService.getInsurancePolicyById(id);
	}
	
	//assign insurancepolicy to user
			@PostMapping("/policy/assignUser/{uId}/{insId}")
			public ResponseEntity<InsurancePolicy> assignUser(@PathVariable("uId") int uId,
						@PathVariable("insId") int insId)
			{
				return new ResponseEntity<InsurancePolicy>(insurancePolicyService.assignUser(uId, insId),
							HttpStatus.CREATED);
			}
	
	@PutMapping("updatePolicy/{id}")   //put mapping to update a policy
	public InsurancePolicyDTO updateInsurancePolicy( @PathVariable int id,@RequestBody InsurancePolicyDTO insurancePolicyDTO)
	{
		final InsurancePolicy insurancePolicy=insurancePolicyConverter.convertToInsurancePolicyEntity(insurancePolicyDTO);
		return insurancePolicyService.updateInsurancePolicy(id, insurancePolicy);
	}
	
	@DeleteMapping("/deletePolicy/{id}")  //delete mapping to delete a policy
	public String deleteInsurancePolicy(@PathVariable int id)
	{
		return insurancePolicyService.deleteInsurancePolicy(id);
	}
}
