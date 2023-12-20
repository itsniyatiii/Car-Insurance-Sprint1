package com.springboot.carinsurance.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.UserDTO;
import com.springboot.carinsurance.entity.User;


@Component
public class UserConverter  //creating User converter class
{

	//convert from DTO to Entity
	public User convertToUserEntity(UserDTO userDTO)
	{
		User user=new User();
		if(userDTO!=null)
		{
			BeanUtils.copyProperties(userDTO, user);
		}
		return user;		
	}
		
		
	//convert from Entity to DTO
	public UserDTO convertToUserDTO(User user)
	{
		UserDTO userDTO=new UserDTO();
		if(user!=null)
		{
			BeanUtils.copyProperties(user, userDTO);
		}
		return userDTO;
	}

}
