package com.springboot.carinsurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //Generates Getter and Setter Method for all the data members
@AllArgsConstructor  //Generates an all-args constructor
@NoArgsConstructor //Generates a no-args constructor
@Builder
@Entity  //Specifying class is an entity
@Table(name="Admin_Details")
public class Admin //Creating Admin class

{
	@Id //making id as a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //making id as AutoGenerated 
	private int adminId;
	
	@NotEmpty(message = "Admin name should not be empty")   
	private String adminEmail;  //Data members
	
	@NotEmpty(message = "Password should not be empty")
	private String adminPassword;
	
	
}
