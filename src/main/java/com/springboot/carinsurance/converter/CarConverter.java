package com.springboot.carinsurance.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.springboot.carinsurance.dto.CarDTO;
import com.springboot.carinsurance.entity.Car;


@Component
public class CarConverter //creating car converter class
{

	//convert from DTO to Entity
	public Car convertToCarEntity(CarDTO carDTO)
	{
		Car car=new Car();
		if(carDTO!=null)
		{
			BeanUtils.copyProperties(carDTO, car);
		}
		return car;
			
	}
		
		
	//convert from Entity to DTO
	public CarDTO convertToCarDTO(Car car)
	{
		CarDTO carDTO=new CarDTO();
		if(car!=null)
		{
			BeanUtils.copyProperties(car, carDTO);
		}
		return carDTO;
		
	}
	
}
