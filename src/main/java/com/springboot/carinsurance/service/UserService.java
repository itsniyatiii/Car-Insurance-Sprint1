package com.springboot.carinsurance.service;

import java.util.List;
import org.springframework.stereotype.Component;

import com.springboot.carinsurance.config.LoginMesage;
import com.springboot.carinsurance.dto.LoginDTO;
import com.springboot.carinsurance.dto.UserDTO;
import com.springboot.carinsurance.entity.User;


@Component
public interface UserService //Creating User service interface
{

	public UserDTO createUser(User user); //method to create a user

	public List<UserDTO> getAllUsers();  //method to retrieve all the users

	public UserDTO getUserById(int id);  //method to retrieve a user
	
	public UserDTO updateUser(int id, User user);  //method to update a user

	public String deleteUser(int id);  //method to delete a user
	
	public LoginMesage  loginUser(LoginDTO loginDTO);
	
	public String addUser(UserDTO userDTO);

	
	
}
