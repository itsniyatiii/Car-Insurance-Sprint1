package com.springboot.carinsurance.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.carinsurance.entity.User;

@Repository
//creating UserRepository interface which extends JpaRepository
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByuserId(int id);
	
	Optional<User> findByUserEmailAndUserPassword(String userEmail, String userPassword);
	 
	 User findByUserEmail(String userEmail);
	 
	
}
