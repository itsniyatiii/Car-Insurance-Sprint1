package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.carinsurance.entity.Car;

@SpringBootTest
public class CarRepositoryTest {

	@Autowired
    private CarRepository carRepository;
 
    
    @Test
    public void testCreateCar() {
    	 // Create and save an car
        Car car = new Car();
        car.setVIN( "K3J5H289746849");
        car.setCar_make("Ferrari");
        car.setCar_model("Roma");
        car.setCar_manufacturing_year(LocalDate.now());
        car.setCar_registration_no("L9G4J6435");

        Car savedCar = carRepository.save(car);
        assertNotNull(savedCar.getCarId());
        System.out.println("testCreateCar is running!");
    }

      
   // @Test
    public void testGetAllCars()
    {
    	carRepository.deleteAll();
    	
    	//create and save multiple car entities
    	Car car1=new Car(1,"L3H864874934","Ferrari","Roma",LocalDate.now(),"876544567",null);
    	Car car2=new Car(2,"N7G56786F565","Ford","Escape",LocalDate.now(),"567887522",null);
    	Car car3=new Car(3,"M9H6F4654677","Polo","Volkswagan",LocalDate.now(),"L9G4J6435",null);
    	
    	carRepository.save(car1);
    	carRepository.save(car2);
    	carRepository.save(car3);
    	
    	//retrieve all cars from the databases
    	List<Car> allCars=carRepository.findAll();
    	
    	//assert that the list is not empty and contains the excepted number of admins
    	assertNotNull(allCars);
    	assertEquals(3,allCars.size());
    }
    
    @Test
    public void testGetCarById() {
        // Create and save an car
        Car car = new Car();
        car.setVIN("F578H743J864");
        car.setCar_make("Ford");
        car.setCar_model("Escape");
        car.setCar_manufacturing_year(LocalDate.now());
        car.setCar_registration_no("333343456");
        car = carRepository.save(car);

        // Retrieve the car by ID
        Car retrievedCar = carRepository.findById(car.getCarId()).orElse(null);

        // Assert that the retrieved car is not null and has the correct ID
        assertNotNull(retrievedCar);
        assertEquals(car.getCarId(), retrievedCar.getCarId());
        assertEquals("F578H743J864", retrievedCar.getVIN());
        assertEquals("Ford", retrievedCar.getCar_make());
        assertEquals("Escape", retrievedCar.getCar_model());
        assertEquals(LocalDate.now(), retrievedCar.getCar_manufacturing_year());
        assertEquals("333343456" ,retrievedCar.getCar_registration_no());
        System.out.println("testGetCarById is running!");
    }

    
    
    @Test
    public void testUpdateCarById() {
        // Create and save an car
        Car car = new Car();
        car.setVIN("K7H65445F886");
        car.setCar_make("Polo");
        car.setCar_model("volkswagan");
        car.setCar_manufacturing_year(LocalDate.now());
        car.setCar_registration_no("333234443");
        car = carRepository.save(car);

        // Update the car's details
        int carId = car.getCarId();
        Car updatedCar = carRepository.findById(carId).orElse(null);
        assertNotNull(updatedCar);

        // Modify the car's attributes
        updatedCar.setVIN("K75G57865677");
        updatedCar.setCar_make("BMW");// Update username
        updatedCar.setCar_model("3 Series"); // Update password
        updatedCar.setCar_manufacturing_year(LocalDate.now()); // Update email
        updatedCar.setCar_registration_no("8764689939");

        // Save the updated car
        updatedCar = carRepository.save(updatedCar);

        // Retrieve the updated car from the database
        Car retrievedCar = carRepository.findById(carId).orElse(null);
        assertNotNull(retrievedCar);

        // Assert that the attributes have been updated
        assertEquals("BMW", retrievedCar.getCar_make());
        assertEquals("3 Series", retrievedCar.getCar_model());
        assertEquals(LocalDate.now(), retrievedCar.getCar_manufacturing_year());
        assertEquals("8764689939", retrievedCar.getCar_registration_no());
        System.out.println("testUpdateAdminById is running!");
       
    }


    
    
    @Test
    public void testDeleteCarById() {
        // Create and save an car
    	Car car = new Car();
        car.setVIN("K7HK87545F886");
        car.setCar_make("Polo");
        car.setCar_model("volkswagan");
        car.setCar_manufacturing_year(LocalDate.now());
        car.setCar_registration_no("333444553");
        car = carRepository.save(car);

        // Get the ID of the car to be deleted
        int carId = car.getCarId();

        // Delete the car by ID
        carRepository.deleteById(carId);

        // Try to retrieve the deleted car by ID, and it should be null
        Car deletedCar = carRepository.findById(carId).orElse(null);
        assertNull(deletedCar);
        System.out.println("testDeleteCarById is running!");
    }



}
