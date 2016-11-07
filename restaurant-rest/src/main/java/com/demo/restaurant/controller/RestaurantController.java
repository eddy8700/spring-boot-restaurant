/**
 * 
 */
package com.demo.restaurant.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

	@Autowired
	private RestaurantService restaurantService;

	@Value("${file.name}")
	private String fileName;

	@Autowired
	private ResourceLoader resourceLoader;

	@RequestMapping(value = "/findMaximumSatisfaction", method = RequestMethod.GET)
	public Long findMaximumSatisfaction() throws IOException {
		LOGGER.info("Loading the file from classpath resource");
		final Resource resource = resourceLoader.getResource("classpath:" + fileName);
		final File readFromFile = resource.getFile();
		LOGGER.info("Parsing the file");
		return restaurantService.findMaximumSatisfaction(readFromFile);

	}

}
