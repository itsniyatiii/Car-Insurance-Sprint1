package com.springboot.carinsurance.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.AdminDTO;
import com.springboot.carinsurance.entity.Admin;

@Component
public class AdminConverter //creating Admin converter class
{

	//convert from DTO to Entity
	public Admin convertToAdminEntity(AdminDTO adminDTO)
	{
		Admin admin=new Admin();
		if(adminDTO!=null)
		{
			BeanUtils.copyProperties(adminDTO, admin);
		}
		return admin;
		
	}
	
	
	//convert from Entity to DTO
	public AdminDTO convertToAdminDTO(Admin admin)
	{
		AdminDTO adminDTO=new AdminDTO();
		if(admin!=null)
		{
			BeanUtils.copyProperties(admin, adminDTO);
		}
		return adminDTO;
	}

}
