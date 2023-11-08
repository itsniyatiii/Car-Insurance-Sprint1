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
import com.springboot.carinsurance.converter.CarConverter;
import com.springboot.carinsurance.dto.CarDTO;
import com.springboot.carinsurance.entity.Car;
import com.springboot.carinsurance.service.CarService;


@RestController
@RequestMapping("/api/car")
public class CarController  //creating Car controller class
{
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarConverter carConverter;
	
	@PostMapping("/createCar")  //post mapping to create a car
	public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO )
	{
		final Car car=carConverter.convertToCarEntity(carDTO);
		return new ResponseEntity<CarDTO>(carService.createCar(car),HttpStatus.CREATED); 
	 }
	
	@GetMapping("/getAllCars")  //get mapping to retrieve all the cars
	public List<CarDTO> getAllCars()
	{
		return carService.getAllCars();
	}
	
	@GetMapping("getCarById/{id}")  //get mapping retrieve a car
	public CarDTO getCarById(@PathVariable int id) 
	{
		return carService.getCarById(id);
	}
	
	@PutMapping("updateCar{id}")   //put mapping to update a car
	public CarDTO updateCar( @PathVariable int id,@RequestBody CarDTO carDTO)
	{
		final Car car=carConverter.convertToCarEntity(carDTO);
		return carService.updateCar(id, car);
	}
	
	@DeleteMapping("/deleteCar/{id}")  //delete mapping to delete a car
	public String deleteCar(@PathVariable int id)
	{
		return carService.deleteCar(id);
	}
	

}
