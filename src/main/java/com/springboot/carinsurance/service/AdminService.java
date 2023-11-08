package com.springboot.carinsurance.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.AdminDTO;
import com.springboot.carinsurance.entity.Admin;

@Component
public interface AdminService //Creating Admin service interface

{
	public AdminDTO createAdmin(Admin admin); //method to create a Admin

	public List<AdminDTO> getAllAdmins();		///method to retrieve all the Admins

	public AdminDTO getAdminById(int id);		//method to retrieve a Admin

	public AdminDTO updateAdmin(int id, Admin admin);	//method to update a Admin

	public String deleteAdmin(int id);			//method to delete a Admin
	

}
