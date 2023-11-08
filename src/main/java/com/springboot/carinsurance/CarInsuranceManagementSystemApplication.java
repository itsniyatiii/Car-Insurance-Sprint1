package com.springboot.carinsurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.springboot.carinsurance.config.JwtFilter;


@SpringBootApplication
public class CarInsuranceManagementSystemApplication 
{

	@SuppressWarnings({ "rawtypes"})
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean=new FilterRegistrationBean();
			registrationBean.setFilter(new JwtFilter());
		    registrationBean.addUrlPatterns("/api/*");
			return registrationBean;
	
	}
	public static void main(String[] args) 
	{
		SpringApplication.run(CarInsuranceManagementSystemApplication.class, args);
		System.out.println("Car Insurance Management System Project is running !!!");
	}

}
 