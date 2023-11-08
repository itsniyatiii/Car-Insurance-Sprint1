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
import com.springboot.carinsurance.converter.UserConverter;
import com.springboot.carinsurance.dto.UserDTO;
import com.springboot.carinsurance.entity.User;
import com.springboot.carinsurance.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController	//creating User controller class
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConverter userConverter;
	
	@PostMapping("/createUser")  //post mapping to create a user
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO )
	{
		final User user=userConverter.convertToUserEntity(userDTO);
		return new ResponseEntity<UserDTO>(userService.createUser(user),HttpStatus.CREATED); 
	 }
	
	
	@GetMapping("/getAllUsers")  //get mapping to retrieve all the users
	public List<UserDTO> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("getUserById/{id}")  //get mapping retrieve a user
	public UserDTO getUserById(@PathVariable int id) 
	{
		return userService.getUserById(id);
	}
	
	@PutMapping("updateUser/{id}")   //put mapping to update a user
	public UserDTO updateUser( @PathVariable int id,@RequestBody UserDTO userDTO)
	{
		final User user=userConverter.convertToUserEntity(userDTO);
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/deleteUser/{id}")  //delete mapping to delete a user
	public String deleteUser(@PathVariable int id)
	{
		return userService.deleteUser(id);
	}
	

}
