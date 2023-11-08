package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.carinsurance.entity.Admin;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
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
	        admin.setAdmin_name("admin1");
	        admin.setAdmin_password("password1");
	        admin.setAdmin_email_address("admin1@example.com");
	        admin.setAdmin_contact_no("9876543210");

	        Admin savedAdmin = adminRepository.save(admin);
	        assertNotNull(savedAdmin.getAdminId());
	        System.out.println("testCreateAdmin is running!");
	    }
	    
	    @Test
	    public void testGetAllAdmins()
	    {
	    	adminRepository.deleteAll();
	    	
	    	//create and save multiple admin entities
	    	Admin admin1=new Admin(1,"admin1","password1","admin1@gmail.com","9087654321");
	    	Admin admin2=new Admin(2,"admin2","password2","admin2@gmail.com","9999654321");
	    	Admin admin3=new Admin(1,"admin3","password3","admin3@gmail.com","9898989898");
	    	
	    	adminRepository.save(admin1);
	    	adminRepository.save(admin2);
	    	adminRepository.save(admin3);
	    	
	    	//retrieve all admins from the databases
	    	List<Admin> allAdmins=adminRepository.findAll();
	    	
	    	//assert that the list is not empty and contains the excepted number of admins
	    	assertNotNull(allAdmins);
	    	assertEquals(3,allAdmins.size());
	    }
	    
	    
	    @Test
	    public void testGetAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdmin_name("admin5");
	        admin.setAdmin_password("password5");
	        admin.setAdmin_email_address("admin5@example.com");
	        admin.setAdmin_contact_no("8989898989");

	        admin = adminRepository.save(admin);

	        // Retrieve the admin by ID
	        Admin retrievedAdmin = adminRepository.findById(admin.getAdminId()).orElse(null);

	        // Assert that the retrieved admin is not null and has the correct ID
	        assertNotNull(retrievedAdmin);
	        assertEquals(admin.getAdminId(), retrievedAdmin.getAdminId());
	        assertEquals("admin5", retrievedAdmin.getAdmin_name());
	        assertEquals("password5", retrievedAdmin.getAdmin_password());
	        assertEquals("admin5@example.com", retrievedAdmin.getAdmin_email_address());
	        assertEquals("8989898989", retrievedAdmin.getAdmin_contact_no());
	        System.out.println("testGetAdminById is running!");
	    }
	    
	    @Test
	    public void testUpdateAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdmin_name("admin1");
	        admin.setAdmin_password("password1");
	        admin.setAdmin_email_address("admin1@example.com");
	        admin.setAdmin_contact_no("8888543210");


	        admin = adminRepository.save(admin);

	        // Update the admin's details
	        int adminId = admin.getAdminId();
	        Admin updatedAdmin = adminRepository.findById(adminId).orElse(null);
	        assertNotNull(updatedAdmin);

	        // Modify the admin's attributes
	        updatedAdmin.setAdmin_name("newAdmin1"); // Update username
	        updatedAdmin.setAdmin_password("newPassword1"); // Update password
	        updatedAdmin.setAdmin_email_address("newAdmin1@example.com"); // Update email
	        updatedAdmin.setAdmin_contact_no("9999999999");

	        // Save the updated admin
	        updatedAdmin = adminRepository.save(updatedAdmin);

	        // Retrieve the updated admin from the database
	        Admin retrievedAdmin = adminRepository.findById(adminId).orElse(null);
	        assertNotNull(retrievedAdmin);

	        // Assert that the attributes have been updated
	        assertEquals("newAdmin1", retrievedAdmin.getAdmin_name());
	        assertEquals("newPassword1", retrievedAdmin.getAdmin_password());
	        assertEquals("newAdmin1@example.com", retrievedAdmin.getAdmin_email_address());
	        assertEquals("9999999999", retrievedAdmin.getAdmin_contact_no());
	        System.out.println("testUpdateAdminById is running!");
	       
	    }   
	    
	    @Test
	    public void testDeleteAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdmin_name("admin2");
	        admin.setAdmin_password("password2");
	        admin.setAdmin_email_address("admin2@example.com");
	        admin.setAdmin_contact_no("8888888888");

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