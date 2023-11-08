package com.springboot.carinsurance.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.carinsurance.converter.UserConverter;
import com.springboot.carinsurance.dao.UserRepository;
import com.springboot.carinsurance.dto.UserDTO;
import com.springboot.carinsurance.entity.User;
import com.springboot.carinsurance.service.UserService;

//Creating  UserServiceImpl class
//Service class implementing Component class
@Service
public class UserServiceImpl implements UserService 
{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	//method to create a user
	public UserDTO createUser(User user)
	{
		User u=userRepository.save(user);
		return userConverter.convertToUserDTO(u);
	}
	
	//method to retrieve all the users
	@Override
	public List<UserDTO> getAllUsers()
	{
		List<User> users=userRepository.findAll();
		
		//list of type DTO
		List<UserDTO> dtoList=new ArrayList<>();
		
		for(User u:users)
		{
			dtoList.add(userConverter.convertToUserDTO(u));
		}
		return dtoList;
	}
	
	//method to retrieve a user
	@Override
	public UserDTO getUserById(int id)
	{
		User user=userRepository.findByuserId(id);
		return userConverter.convertToUserDTO(user);
	}
	
	//method to update a user
	@Override
	public UserDTO updateUser(int id, User user)
	{
		User u=userRepository.findByuserId(id);
		u.setUser_name(user.getUser_name());
		u.setUser_password(user.getUser_password());
		u.setUser_contact_no(user.getUser_contact_no());
		u.setUser_address(user.getUser_address());
		
		User uu=userRepository.save(u);
		return userConverter.convertToUserDTO(uu);
	}
	
	//method to delete a user
	@Override
	public String deleteUser(int id)
	{
		userRepository.deleteById(id);
		return "User got deleted successfully";
	}


}
