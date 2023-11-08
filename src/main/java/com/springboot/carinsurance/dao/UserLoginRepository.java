package com.springboot.carinsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.carinsurance.entity.UserLogin;

@Repository
//creating UserLoginRepository interface which extends JpaRepository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

	UserLogin findByUsernameAndPassword(String username, String password);

}
