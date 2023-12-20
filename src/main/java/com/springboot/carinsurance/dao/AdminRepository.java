package com.springboot.carinsurance.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.carinsurance.entity.Admin;


@Repository //Indicates that an annotated class is a "Repository", 
//creating AdminRepository interface which extends JpaRepository
public interface AdminRepository extends JpaRepository<Admin, Integer> 
{
	Admin findByadminId(int id);
		
	
	//Admin findByAdminId(int adminId);
	Admin findByAdminEmail(String adminEmail);
	Optional<Admin> findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
}
