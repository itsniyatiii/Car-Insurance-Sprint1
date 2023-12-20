package com.springboot.carinsurance.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.carinsurance.entity.Demo;
import com.springboot.carinsurance.service.DemoService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@RestController
@RequestMapping("/api/userLogin")
public class DemoController
{

	@Autowired
	private DemoService demoService;
	
	@PostMapping("/login")
	public String validate(@RequestBody Demo demo) throws ServletException
	{
		String jwtToken="";
		
		if(demo.getUsername()==null || demo.getPassword()==null)
		{
			throw new ServletException("Please Fill in Username and Password");
		}
		
		String username=demo.getUsername();
		String password=demo.getPassword();
		//will check in database whether the login and password is present or not
		demo=demoService.login(username, password);
		
		if(demo==null)
		{
			throw new ServletException("User not found");
		}
		
		jwtToken=Jwts.builder().setSubject(username).claim("username", demo.getUsername()).
			setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		
		return jwtToken;
		
		
	}
	

}
