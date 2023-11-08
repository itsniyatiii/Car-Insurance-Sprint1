package com.springboot.carinsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.carinsurance.entity.Car;


@Repository
//creating CarRepository interface which extends JpaRepository
public interface CarRepository extends JpaRepository<Car, Integer> 
{
	Car findBycarId(int id);

}
