package com.springboot.carinsurance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

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
        car.setCar_manufacturing_year("2023");
        car.setCar_registration_no("L9G4J6435");
        car.setPolicy_issued_date(LocalDate.of(2022, 01, 01));
        car.setPolicy_end_date(LocalDate.of(2023, 01, 01));

        Car savedCar = carRepository.save(car);
        assertNotNull(savedCar.getCarId());
        System.out.println("testCreateCar is running!");
    }

      
    @Test
    public void testGetCarById()
    {
        // Create and save an car
        Car car = new Car();
        car.setVIN("F578H743J864");
        car.setCar_make("Ford");
        car.setCar_model("Escape");
        car.setCar_manufacturing_year("2022");
        car.setCar_registration_no("333343456");
        car.setPolicy_issued_date(LocalDate.of(2023, 01, 01));
        car.setPolicy_end_date(LocalDate.of(2024, 01, 01));
        car = carRepository.save(car);

        // Retrieve the car by ID
        Car retrievedCar = carRepository.findById(car.getCarId()).orElse(null);

        // Assert that the retrieved car is not null and has the correct ID
        assertNotNull(retrievedCar);
        assertEquals(car.getCarId(), retrievedCar.getCarId());
        assertEquals("F578H743J864", retrievedCar.getVIN());
        assertEquals("Ford", retrievedCar.getCar_make());
        assertEquals("Escape", retrievedCar.getCar_model());
        assertEquals("2022", retrievedCar.getCar_manufacturing_year());
        assertEquals("333343456" ,retrievedCar.getCar_registration_no());
        assertEquals(LocalDate.of(2023, 01, 01) ,retrievedCar.getPolicy_issued_date());
        assertEquals(LocalDate.of(2024, 01, 01) ,retrievedCar.getPolicy_end_date());
        
        System.out.println("testGetCarById is running!");
    }

    
    
    @Test
    public void testUpdateCarById() {
        // Create and save an car
        Car car = new Car();
        car.setVIN("K7H65445F886");
        car.setCar_make("Polo");
        car.setCar_model("volkswagan");
        car.setCar_manufacturing_year("2021");
        car.setCar_registration_no("333234443");
        car.setPolicy_issued_date(LocalDate.of(2019, 10, 10));
        car.setPolicy_end_date(LocalDate.of(2020, 10, 10));
        car = carRepository.save(car);

        // Update the car's details
        int carId = car.getCarId();
        Car updatedCar = carRepository.findById(carId).orElse(null);
        assertNotNull(updatedCar);

        // Modify the car's attributes
        updatedCar.setVIN("K75G57865677");
        updatedCar.setCar_make("BMW");// Update username
        updatedCar.setCar_model("3 Series"); // Update password
        updatedCar.setCar_manufacturing_year("2022"); // Update email
        updatedCar.setCar_registration_no("8764689939");
        updatedCar.setPolicy_issued_date(LocalDate.of(2019, 10, 12));
        updatedCar.setPolicy_end_date(LocalDate.of(2020, 10, 12));

        // Save the updated car
        updatedCar = carRepository.save(updatedCar);

        // Retrieve the updated car from the database
        Car retrievedCar = carRepository.findById(carId).orElse(null);
        assertNotNull(retrievedCar);

        // Assert that the attributes have been updated
        assertEquals("BMW", retrievedCar.getCar_make());
        assertEquals("3 Series", retrievedCar.getCar_model());
        assertEquals("2022", retrievedCar.getCar_manufacturing_year());
        assertEquals("8764689939", retrievedCar.getCar_registration_no());
        assertEquals(LocalDate.of(2019, 10, 12), retrievedCar.getPolicy_issued_date());
        assertEquals(LocalDate.of(2020, 10, 12), retrievedCar.getPolicy_end_date());
        System.out.println("testUpdateAdminById is running!");
       
    }


    
    
    @Test
    public void testDeleteCarById() {
        // Create and save an car
    	Car car = new Car();
        car.setVIN("K7HK87545F886");
        car.setCar_make("Polo");
        car.setCar_model("volkswagan");
        car.setCar_manufacturing_year("2023");
        car.setCar_registration_no("333444553");
        car.setPolicy_issued_date(LocalDate.of(2023, 02, 02));
        car.setPolicy_end_date(LocalDate.of(2024, 02, 02));
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
