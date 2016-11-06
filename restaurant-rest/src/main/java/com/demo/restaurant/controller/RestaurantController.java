/**
 * 
 */
package com.demo.restaurant.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.restaurant.api.RestaurantService;

/**
 * @author aditya
 *
 */
@RestController
public class RestaurantController {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(RestaurantController.class);
	
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@RequestMapping(value="/findMaximumSatisfaction",method=RequestMethod.GET)
	public Long findMaximumSatisfaction(){
		LOGGER.info("Loading the file from classpath resource");
		Resource classpathResource= new  ClassPathResource("data.txt");
		LOGGER.info("Parsing the file");
		try {
			 return restaurantService.findMaximumSatisfaction(classpathResource.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
