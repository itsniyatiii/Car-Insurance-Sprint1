package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.carinsurance.entity.User;
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository userRepository;
 
    
    @Test
    public void testCreateUser() {
    	 // Create and save an user
        User user = new User();
        user.setUser_name("Niyati");
        user.setUser_password("5678");
        user.setUser_contact_no("9090988765");
        user.setUser_address("Ahmednagar");

        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getUserId());
        System.out.println("testCreateUser is running!");
    }
    
   // @Test
    public void testGetAllUsers()
    {
    	userRepository.deleteAll();
    	
    	//create and save multiple user entities
    	User user1=new User(1,"user1","password1","9090909090","Pune");
    	User user2=new User(2,"user2","password2","8888809090","Mumbai");   
    	User user3=new User(3,"user3","password3","8080808080","Delhi");
    	
    	userRepository.save(user1);
    	userRepository.save(user2);
    	userRepository.save(user3);
    	
    	//retrieve all users from the databases
    	List<User> allUsers=userRepository.findAll();
    	
    	//assert that the list is not empty and contains the excepted number of users
    	assertNotNull(allUsers);
    	assertEquals(3,allUsers.size());
    }
    
    
    
    @Test
    public void testGetUserById() {
        // Create and save an user
        User user = new User();
        user.setUser_name("John");
        user.setUser_password("1212");
        user.setUser_contact_no("8880988765");
        user.setUser_address("Pune");
        user = userRepository.save(user);

        // Retrieve the user by ID
        User retrievedUser = userRepository.findById(user.getUserId()).orElse(null);

        // Assert that the retrieved user is not null and has the correct ID
        assertNotNull(retrievedUser);
        assertEquals(user.getUserId(), retrievedUser.getUserId());
        assertEquals("John", retrievedUser.getUser_name());
        assertEquals("1212", retrievedUser.getUser_password());
        assertEquals("8880988765", retrievedUser.getUser_contact_no());
        assertEquals("Pune", retrievedUser.getUser_address());
        System.out.println("testGetUserById is running!");
    }

    
    
    @Test
    public void testUpdateUserById() {
        // Create and save an user
        User user = new User();
        user.setUser_name("John");
        user.setUser_password("1212");
        user.setUser_contact_no("8880988765");
        user.setUser_address("Pune");
        user = userRepository.save(user);

        // Update the user's details
        int userId = user.getUserId();
        User updatedUser = userRepository.findById(userId).orElse(null);
        assertNotNull(updatedUser);

        // Modify the user's attributes
        updatedUser.setUser_name("James"); 
        updatedUser.setUser_password("9876");
        updatedUser.setUser_contact_no("7788990066");
        updatedUser.setUser_address("Delhi");

        // Save the updated user
        updatedUser = userRepository.save(updatedUser);

        // Retrieve the updated user from the database
        User retrievedUser = userRepository.findById(userId).orElse(null);
        assertNotNull(retrievedUser);

        // Assert that the attributes have been updated
        assertEquals("James", retrievedUser.getUser_name());
        assertEquals("9876", retrievedUser.getUser_password());
        assertEquals("7788990066", retrievedUser.getUser_contact_no());
        assertEquals("Delhi", retrievedUser.getUser_address());
        System.out.println("testUpdateUserById is running!");
       
    }


    
    
    @Test
    public void testDeleteUserById() {
        // Create and save an user
        User user = new User();
        user.setUser_name("John");
        user.setUser_password("1212");
        user.setUser_contact_no("8880988765");
        user.setUser_address("Pune");

        user = userRepository.save(user);

        // Get the ID of the user to be deleted
        int userId = user.getUserId();

        // Delete the user by ID
        userRepository.deleteById(userId);

        // Try to retrieve the deleted user by ID, and it should be null
        User deletedUser = userRepository.findById(userId).orElse(null);
        assertNull(deletedUser);
        System.out.println("testDeleteUserById is running!");
    }



}
