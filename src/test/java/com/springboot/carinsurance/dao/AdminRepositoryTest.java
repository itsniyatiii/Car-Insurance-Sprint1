package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springboot.carinsurance.entity.Admin;

@SpringBootTest
public class AdminRepositoryTest 
{
	 @Autowired
	    private AdminRepository adminRepository;
	 
	    
	    @Test
	    public void testCreateAdmin() 
	    {
	    	// Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdminEmail("admin@gmail.com");
	        admin.setAdminPassword("password1");
	        Admin savedAdmin = adminRepository.save(admin);
	        assertNotNull(savedAdmin.getAdminId());
	        System.out.println("testCreateAdmin is running!");
	    }
	    
	    
	    @Test
	    public void testGetAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdminEmail("admin5@gmail.com");
	        admin.setAdminPassword("password5");
	        admin = adminRepository.save(admin);

	        // Retrieve the admin by ID
	        Admin retrievedAdmin = adminRepository.findById(admin.getAdminId()).orElse(null);

	        // Assert that the retrieved admin is not null and has the correct ID
	        assertNotNull(retrievedAdmin);
	        assertEquals(admin.getAdminId(), retrievedAdmin.getAdminId());
	        assertEquals("admin5@gmail.com", retrievedAdmin.getAdminEmail());
	        assertEquals("password5", retrievedAdmin.getAdminPassword());
	        System.out.println("testGetAdminById is running!");
	    }
	    
	    @Test
	    public void testUpdateAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdminEmail("admin1@gmail.com");
	        admin.setAdminPassword("password1");

	        admin = adminRepository.save(admin);

	        // Update the admin's details
	        int adminId = admin.getAdminId();
	        Admin updatedAdmin = adminRepository.findById(adminId).orElse(null);
	        assertNotNull(updatedAdmin);

	        // Modify the admin's attributes
	        updatedAdmin.setAdminEmail("admin@gmail.com"); // Update username
	        updatedAdmin.setAdminPassword("newPassword1"); // Update password
	        // Save the updated admin
	        updatedAdmin = adminRepository.save(updatedAdmin);

	        // Retrieve the updated admin from the database
	        Admin retrievedAdmin = adminRepository.findById(adminId).orElse(null);
	        assertNotNull(retrievedAdmin);

	        // Assert that the attributes have been updated
	        assertEquals("admin@gmail.com", retrievedAdmin.getAdminEmail());
	        assertEquals("newPassword1", retrievedAdmin.getAdminPassword());
	        System.out.println("testUpdateAdminById is running!");
	       
	    }   
	    
	    @Test
	    public void testDeleteAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdminEmail("admin2@gmail.com");
	        admin.setAdminPassword("password2");
	        admin = adminRepository.save(admin);
 
	        // Get the ID of the admin to be deleted
	        int adminId = admin.getAdminId();

	        // Delete the admin by ID
	        adminRepository.deleteById(adminId);

	        // Try to retrieve the deleted admin by ID, and it should be null
	        Admin deletedAdmin = adminRepository.findById(adminId).orElse(null);
	        assertNull(deletedAdmin);
	        System.out.println("testDeleteAdminById is running!");
	    }



}