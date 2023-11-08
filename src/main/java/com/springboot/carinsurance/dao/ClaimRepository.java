package com.springboot.carinsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.carinsurance.entity.Claim;

@Repository
//creating ClaimRepository interface which extends JpaRepository
public interface ClaimRepository extends JpaRepository<Claim, Integer> 
{

	Claim findByclaimId(int id);
}
