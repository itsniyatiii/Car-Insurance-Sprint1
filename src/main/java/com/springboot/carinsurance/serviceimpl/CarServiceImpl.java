package com.springboot.carinsurance.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springboot.carinsurance.converter.CarConverter;
import com.springboot.carinsurance.dao.CarRepository;
import com.springboot.carinsurance.dto.CarDTO;
import com.springboot.carinsurance.entity.Car;
import com.springboot.carinsurance.service.CarService;

//Creating CarServiceImpl class
//Service class implementing Component class
@Service
 public  class CarServiceImpl implements CarService 
 {
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarConverter carConverter;
	
	//method to create a car
	public CarDTO createCar(Car car) 
	{
		Car c=carRepository.save(car);
		return carConverter.convertToCarDTO(c);
	}
	
	//method to retrieve all the cars
	@Override
	public List<CarDTO> getAllCars()
	{
		List<Car> cars=carRepository.findAll();
		
		//list of type DTO
		List<CarDTO> dtoList=new ArrayList<>();
		
		for(Car c:cars)
		{
			dtoList.add(carConverter.convertToCarDTO(c));
		}
		return dtoList;
	}
	
	//method to retrieve a car
	@Override
	public CarDTO getCarById(int id) 
	{
		Car car=carRepository.findBycarId(id);
		return carConverter.convertToCarDTO(car);
	}
		
	//method to update a car
	@Override
	public CarDTO updateCar(int id, Car car)
	{
		Car c=carRepository.findBycarId(id);
		c.setVIN(car.getVIN());
		c.setCar_make(car.getCar_make());
		c.setCar_model(car.getCar_model());
		c.setCar_manufacturing_year(car.getCar_manufacturing_year());
		c.setCar_registration_no(car.getCar_registration_no());
		c.setPolicy(car.getPolicy());
		
		Car cc=carRepository.save(c);
		return carConverter.convertToCarDTO(cc);
	}
	//method to delete a car
	public String deleteCar(int id) 
	{
		carRepository.deleteById(id);
		return "Car got deleted successfully";
	}


}
