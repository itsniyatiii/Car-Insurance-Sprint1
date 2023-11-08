package com.springboot.carinsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.carinsurance.entity.InsurancePolicy;

@Repository
//creating InsurancePolicyRepository interface which extends JpaRepository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>
{
	InsurancePolicy findBypolicyId(int id);

}
