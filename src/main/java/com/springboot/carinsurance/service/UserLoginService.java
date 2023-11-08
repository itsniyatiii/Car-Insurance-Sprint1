package com.springboot.carinsurance.service;

import org.springframework.stereotype.Component;

import com.springboot.carinsurance.entity.UserLogin;

@Component
public interface UserLoginService //Creating UserLogin service interface
{

	public UserLogin login(String username, String password); 

}
