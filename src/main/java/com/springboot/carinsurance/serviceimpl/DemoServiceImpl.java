package com.springboot.carinsurance.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.carinsurance.dao.DemoRepository;
import com.springboot.carinsurance.entity.Demo;
import com.springboot.carinsurance.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService //Creating  UserLoginServiceImpl class
{

	@Autowired
	private DemoRepository userLoginRepository;
	
	@Override
	public Demo login(String username, String password) {
		Demo demo=userLoginRepository.findByUsernameAndPassword(username, password);
		return demo;
	}

}
