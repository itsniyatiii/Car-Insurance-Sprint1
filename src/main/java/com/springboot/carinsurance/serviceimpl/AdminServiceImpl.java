package com.springboot.carinsurance.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.carinsurance.config.LoginMesage;
import com.springboot.carinsurance.dao.AdminRepository;
import com.springboot.carinsurance.dto.ALoginDTO;
import com.springboot.carinsurance.entity.Admin;
import com.springboot.carinsurance.service.AdminService;

//Creating Admin Service class
//Service class implementing Component class
@Service
public class AdminServiceImpl implements AdminService 
{
	//instance of Repository class of Admin
	@Autowired
	private AdminRepository adminRepository;

	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public LoginMesage loginAdmin(ALoginDTO loginDTO)
	{
		String msg="";
		Admin admin1=adminRepository.findByAdminEmail(loginDTO.getAdminEmail());
		if(admin1!=null)
		{
			String adminPassword = loginDTO.getAdminPassword();
			String encodedPassword = admin1.getAdminPassword();
			//Boolean isPwdRight = passwordEncoder.matches(adminPassword, encodedPassword);
			Boolean isPwdRight = adminPassword.equals(encodedPassword);
			if(isPwdRight)
			{
				Optional<Admin> admin = adminRepository.findByAdminEmailAndAdminPassword(loginDTO.getAdminEmail(),encodedPassword);
				if(admin.isPresent())
				{
					return new LoginMesage("Login Success", true);
				}
				else 
				{
					return new LoginMesage("Login Failed", false);
				}
			}
			else 
			{
				return new LoginMesage("Password Not Match", false);
			}
			}
		else 
		{
			return new LoginMesage("Email not exist", false);
		}
	}

	

}
