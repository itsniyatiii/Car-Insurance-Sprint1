package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.carinsurance.entity.User;
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository userRepository;
 
    
	 @Test
	    public void testCreateUser()
	 {
	    	 // Create and save an user
	        User user = new User();
	        user.setUserFirstName("Niyati");
	        user.setUserLastName("Ghodke");
	        user.setUserAadhar("123456789123");
	        user.setUserAge(25);
	        user.setUserCity("Mumbai");
	        user.setUserMobile("1234567890");
	        user.setUserEmail("niyati@gmail.com");
	        user.setUserUserName("niyati1234");
	        user.setUserPassword("98765");

	        User savedUser = userRepository.save(user);
	        assertNotNull(savedUser.getUserId());
	    }
	        
	    
	    @Test
	    public void testGetUserById() {
	        // Create and save an user
	        User user = new User();
	        user.setUserFirstName("Niyati");
	        user.setUserLastName("Ghodke");
	        user.setUserAadhar("123456789123");
	        user.setUserAge(25);
	        user.setUserCity("Mumbai");
	        user.setUserMobile("1234567890");
	        user.setUserEmail("niyati@gmail.com");
	        user.setUserUserName("niyatighodke");
	        user.setUserPassword("niyati123");

	        user = userRepository.save(user);

	        // Retrieve the user by ID
	        User retrievedUser = userRepository.findById(user.getUserId()).orElse(null);

	        // Assert that the retrieved user is not null and has the correct ID
	        assertNotNull(retrievedUser);
	        assertEquals(user.getUserId(), retrievedUser.getUserId());
	        assertEquals("Niyati", retrievedUser.getUserFirstName());
	        assertEquals("Ghodke", retrievedUser.getUserLastName());
	        assertEquals("123456789123", retrievedUser.getUserAadhar());
	        assertEquals(25, retrievedUser.getUserAge());
	        assertEquals("Mumbai", retrievedUser.getUserCity());
	        assertEquals("1234567890", retrievedUser.getUserMobile());
	        assertEquals("niyati@gmail.com", retrievedUser.getUserEmail());
	        assertEquals("niyatighodke", retrievedUser.getUserUserName());
	        assertEquals("niyati123", retrievedUser.getUserPassword());
	    }
	
	    
	    
	    @Test
	    public void testUpdateUserById() {
	        // Create and save an user
	        User user = new User();
	        user.setUserFirstName("Niyati");
	        user.setUserLastName("Ghodke");
	        user.setUserAadhar("123456789123");
	        user.setUserAge(25);
	        user.setUserCity("Mumbai");
	        user.setUserMobile("1234567890");
	        user.setUserEmail("niyati@gmail.com");
	        user.setUserUserName("niyatighodke");
	        user.setUserPassword("niyati123");

	        user = userRepository.save(user);

	        // Update the user's details
	        int userId = user.getUserId();
	        User updatedUser = userRepository.findById(userId).orElse(null);
	        assertNotNull(updatedUser);

	        // Modify the user's attributes
	        updatedUser.setUserFirstName("Nakshtra"); 
	        updatedUser.setUserLastName("Ghodake"); 
	        updatedUser.setUserAadhar("123456789123"); 
	        updatedUser.setUserAge(25);
	        updatedUser.setUserCity("Mumbai"); 
	        updatedUser.setUserMobile("1234567890"); 
	        updatedUser.setUserEmail("nakshtra@gmail.com"); 
	        updatedUser.setUserUserName("nakshtrahodake"); 
	        updatedUser.setUserPassword("nakshtra123"); 

	        // Save the updated user
	        updatedUser = userRepository.save(updatedUser);

	        // Retrieve the updated user from the database
	        User retrievedUser = userRepository.findById(userId).orElse(null);
	        assertNotNull(retrievedUser);

	        // Assert that the attributes have been updated
	        assertEquals("Nakshtra", retrievedUser.getUserFirstName());
	        assertEquals("Ghodake", retrievedUser.getUserLastName());
	        assertEquals("123456789123", retrievedUser.getUserAadhar());
	        assertEquals(25, retrievedUser.getUserAge());
	        assertEquals("Mumbai", retrievedUser.getUserCity());
	        assertEquals("1234567890", retrievedUser.getUserMobile());
	        assertEquals("nakshtra@gmail.com", retrievedUser.getUserEmail());
	        assertEquals("nakshtrahodake", retrievedUser.getUserUserName());
	        assertEquals("nakshtra123", retrievedUser.getUserPassword());
	    }


	    
	    
	    @Test
	    public void testDeleteUserById() {
	        // Create and save an user
	        User user = new User();
	        user.setUserFirstName("Niyati");
	        user.setUserLastName("Ghodke");
	        user.setUserAadhar("123456789123");
	        user.setUserAge(25);
	        user.setUserCity("Mumbai");
	        user.setUserMobile("1234567890");
	        user.setUserEmail("niyati@gmail.com");
	        user.setUserUserName("niyatighodke");
	        user.setUserPassword("niyati123");

	        user = userRepository.save(user);

	        // Get the ID of the user to be deleted
	        int userId = user.getUserId();

	        // Delete the user by ID
	        userRepository.deleteById(userId);

	        // Try to retrieve the deleted user by ID, and it should be null
	        User deletedUser = userRepository.findById(userId).orElse(null);
	        assertNull(deletedUser);
	    }

	
}
