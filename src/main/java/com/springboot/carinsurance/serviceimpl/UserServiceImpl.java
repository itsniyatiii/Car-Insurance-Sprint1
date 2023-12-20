package com.springboot.carinsurance.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.carinsurance.config.LoginMesage;
import com.springboot.carinsurance.converter.UserConverter;
import com.springboot.carinsurance.dao.UserRepository;
import com.springboot.carinsurance.dto.LoginDTO;
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
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
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
		u.setUserFirstName(user.getUserFirstName());
		u.setUserLastName(user.getUserLastName());
		u.setUserAadhar(user.getUserAadhar());
		u.setUserAge(user.getUserAge());
		u.setUserCity(user.getUserCity());
		u.setUserMobile(user.getUserMobile());
		u.setUserUserName(user.getUserUserName());
		u.setUserPassword(user.getUserPassword());
		u.setUserEmail(user.getUserEmail());
		
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
	
	//method for user registration
	@Override
	 public String addUser(UserDTO userDTO) 
	{
		    User user = new User();
		    
		    user.setUserId(userDTO.getUserId());
		    user.setUserFirstName(userDTO.getUserFirstName());
		    user.setUserLastName(userDTO.getUserLastName());
		    user.setUserAadhar(userDTO.getUserAadhar());
		    user.setUserAge(userDTO.getUserAge());
		    user.setUserCity(userDTO.getUserCity());
		    user.setUserMobile(userDTO.getUserMobile());
		    user.setUserEmail(userDTO.getUserEmail());
		    user.setUserUserName(userDTO.getUserUserName());
		    user.setUserPassword(this.passwordEncoder.encode(userDTO.getUserPassword()));
		    
		    userRepository.save(user);
		    return user.getUserUserName();
		}
	    
	    

	//method for user login
	@Override
	public LoginMesage loginUser(LoginDTO loginDTO)
	{
		String msg="";
		User user1 = userRepository.findByUserEmail(loginDTO.getUserEmail());
		if(user1 != null) 
		{
			String password = loginDTO.getUserPassword();
			String encodedPassword = user1.getUserPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight) 
			{
				Optional<User> user = userRepository.findByUserEmailAndUserPassword(loginDTO.getUserEmail(), encodedPassword);
				if (user.isPresent()) {
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
			return new LoginMesage("Email not exist",false);
		}
	}

}
