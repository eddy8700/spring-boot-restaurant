package com.demo.restaurant.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;



@SpringBootApplication
@ComponentScan(basePackages="com.demo.restaurant")
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class RestaurantApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}
}
