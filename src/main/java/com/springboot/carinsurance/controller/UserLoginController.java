package com.springboot.carinsurance.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.carinsurance.entity.UserLogin;
import com.springboot.carinsurance.service.UserLoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@RestController
@RequestMapping("/api/userLogin")
public class UserLoginController 	//creating UserLogin controller class
{

	@Autowired
	private UserLoginService userLoginService;
	
	@PostMapping("/login")
	public String validate(@RequestBody UserLogin user) throws ServletException
	{
		String jwtToken="";
		
		if(user.getUsername()==null || user.getPassword()==null)
		{
			throw new ServletException("Please Fill in Username and Password");
		}
		
		String username=user.getUsername();
		String password=user.getPassword();
		//will check in database whether the login and password is present or not
		user=userLoginService.login(username, password);
		
		if(user==null)
		{
			throw new ServletException("User not found");
		}
		
		jwtToken=Jwts.builder().setSubject(username).claim("username", user.getUsername()).
			setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		
		return jwtToken;
		
		
	}
	

}
