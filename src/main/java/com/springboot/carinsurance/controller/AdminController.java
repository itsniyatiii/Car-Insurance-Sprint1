package com.springboot.carinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.carinsurance.config.LoginMesage;
import com.springboot.carinsurance.converter.AdminConverter;
import com.springboot.carinsurance.dto.ALoginDTO;
import com.springboot.carinsurance.service.AdminService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController //creating Admin controller class
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminConverter adminConverter;
	
	
	@PostMapping(path="/login/admin")
	public ResponseEntity<?> loginUser(@RequestBody ALoginDTO loginDTO)
	{
		LoginMesage loginResponse = adminService.loginAdmin(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
	
	
	
}
