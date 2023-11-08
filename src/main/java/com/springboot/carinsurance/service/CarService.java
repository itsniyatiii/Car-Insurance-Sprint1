package com.springboot.carinsurance.service;

import java.util.List;

import org.springframework.stereotype.Component;


import com.springboot.carinsurance.dto.CarDTO;
import com.springboot.carinsurance.entity.Car;

@Component
public interface CarService //Creating Car service interface
{
	public CarDTO createCar(Car car); //method to create a car

	public List<CarDTO> getAllCars(); //method to retrieve all the car

	public CarDTO getCarById(int id); //method to retrieve a car

	public CarDTO updateCar(int id, Car car); //method to update a car

	public String deleteCar(int id); //method to delete a car
	
}
