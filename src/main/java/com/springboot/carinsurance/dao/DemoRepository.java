package com.springboot.carinsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.carinsurance.entity.Demo;

@Repository
//creating UserLoginRepository interface which extends JpaRepository
public interface DemoRepository extends JpaRepository<Demo, Integer> {

	Demo findByUsernameAndPassword(String username, String password);

}
