package com.springboot.carinsurance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.carinsurance.converter.AdminConverter;
import com.springboot.carinsurance.dto.AdminDTO;
import com.springboot.carinsurance.entity.Admin;
import com.springboot.carinsurance.service.AdminService;


@RestController
@RequestMapping("/api/admin")
public class AdminController //creating Admin controller class
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminConverter adminConverter;
	
	@PostMapping("/createAdmin") //post mapping to create a admin
	public ResponseEntity<AdminDTO> createAdmin(@RequestBody AdminDTO adminDTO )
	{
		final Admin admin=adminConverter.convertToAdminEntity(adminDTO);
		return new ResponseEntity<AdminDTO>(adminService.createAdmin(admin),HttpStatus.CREATED); 
	 }
	
	@GetMapping("/getAllAdmins")  //get mapping to retrieve all the admins
	public List<AdminDTO> getAllAdmins()
	{
		return adminService.getAllAdmins();
	}
	
	@GetMapping("getAdminById/{id}") //get mapping retrieve a admin
	public AdminDTO getAdminById(@PathVariable int id) 
	{
		return adminService.getAdminById(id);
	}
	
	@PutMapping("updateAdmin/{id}") //put mapping to update a admin
	public AdminDTO updateAdmin( @PathVariable int id,@RequestBody AdminDTO adminDTO)
	{
		final Admin admin=adminConverter.convertToAdminEntity(adminDTO);
		return adminService.updateAdmin(id, admin);
	}
	
	@DeleteMapping("/deleteAdmin/{id}") //delete mapping to delete a admin
	public String deleteAdmin(@PathVariable int id)
	{
		return adminService.deleteAdmin(id);
	}
	
}
