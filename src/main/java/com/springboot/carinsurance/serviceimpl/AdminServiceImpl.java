package com.springboot.carinsurance.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.carinsurance.converter.AdminConverter;
import com.springboot.carinsurance.dao.AdminRepository;
import com.springboot.carinsurance.dto.AdminDTO;
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
	
	//instance of Converter class of Admin
	@Autowired
	private AdminConverter adminConverter;
	
	//method to create a Admin
	public AdminDTO createAdmin(Admin admin) 
	{
		Admin a=adminRepository.save(admin);
		return adminConverter.convertToAdminDTO(a);
	}
	
	//method to retrieve all the Admins
	@Override
	public List<AdminDTO> getAllAdmins() 
	{
		List<Admin> admins=adminRepository.findAll();
		
		//list of type DTO
		List<AdminDTO> dtoList=new ArrayList<>();
		
		for(Admin a:admins)
		{
			dtoList.add(adminConverter.convertToAdminDTO(a));
		}
		return dtoList;
	}
	
	//method to retrieve a Admin
	@Override
	public AdminDTO getAdminById(int id) 
	{
		Admin admin=adminRepository.findByadminId(id);
		return adminConverter.convertToAdminDTO(admin);
	}
	
	//method to update a Admin
	@Override
	public AdminDTO updateAdmin(int id, Admin admin)
	{
		Admin a=adminRepository.findByadminId(id);
		a.setAdmin_name(admin.getAdmin_name());
		a.setAdmin_password(admin.getAdmin_password());
		a.setAdmin_email_address(admin.getAdmin_email_address());
		a.setAdmin_contact_no(admin.getAdmin_contact_no());
		
		Admin aa=adminRepository.save(a);
		return adminConverter.convertToAdminDTO(aa);
	}
	
	//method to delete a Admin
	@Override
	public String deleteAdmin(int id)
	{
		adminRepository.deleteById(id);
		return "Admins got deleted successfully";
	}


	

	
	

}
