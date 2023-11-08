package com.springboot.carinsurance.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.carinsurance.dao.UserLoginRepository;
import com.springboot.carinsurance.entity.UserLogin;
import com.springboot.carinsurance.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService //Creating  UserLoginServiceImpl class
{

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Override
	public UserLogin login(String username, String password) {
		UserLogin user=userLoginRepository.findByUsernameAndPassword(username, password);
		return user;
	}

}
