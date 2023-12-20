package com.springboot.carinsurance.service;

import org.springframework.stereotype.Component;

import com.springboot.carinsurance.entity.Demo;

@Component
public interface DemoService
{

	public Demo login(String username, String password); 

}
