package com.springboot.carinsurance.service;


import org.springframework.stereotype.Component;

import com.springboot.carinsurance.config.LoginMesage;
import com.springboot.carinsurance.dto.ALoginDTO;

@Component
public interface AdminService //Creating Admin service interface

{
	public LoginMesage  loginAdmin(ALoginDTO loginDTO);

}
