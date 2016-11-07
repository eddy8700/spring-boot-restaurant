/**
 * 
 */
package com.demo.restaurant.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.restaurant.api.RestaurantService;

/**
 * @author aditya
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantServiceImpl.class);

	private final String SPLIT_EXPRESSION = " ";

	/**
	 * fileToRead to read file from classpath return Long maximumsatisfaction
	 * @throws FileNotFoundException 
	 */
	public Long findMaximumSatisfaction(final File fileToRead) throws FileNotFoundException {
		if(fileToRead==null){
			throw new FileNotFoundException("File is missing from classpath");
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))) {
			String firstLine = null;
			String[] firstLineArray = reader.readLine().split(SPLIT_EXPRESSION);
			final Integer minutesToEat = new Integer(firstLineArray[0]);
			final Integer noOfItems = new Integer(firstLineArray[1]);
			Integer[] satisactionValueArray = new Integer[noOfItems];
			Integer[] timeConsumeArray = new Integer[noOfItems];
			int i = 0;
			while ((firstLine = reader.readLine()) != null) {
				// loop will run from 2nd line
				String[] values = firstLine.split(SPLIT_EXPRESSION);
				satisactionValueArray[i] = new Integer(values[0]);
				timeConsumeArray[i] = new Integer(values[1]);
				i++;
			}
			return buildMaximumSatisfactionForAGivenTime(minutesToEat, timeConsumeArray, satisactionValueArray, noOfItems);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 
	 * @param minutes
	 * @param timeConsumeArray
	 * @param satisactionValueArray
	 * @param noOfItems
	 */
	private Long buildMaximumSatisfactionForAGivenTime(Integer minutes, Integer[] timeConsumeArray,
			Integer[] satisactionValueArray, Integer noOfItems) {
		// TODO Auto-generated method stub
		final Long backTrackArray[][] = new Long[noOfItems + 1][minutes + 1];
		final Long[][] arrayHoldingMaximum = new Long[noOfItems + 1][minutes + 1];
		for (int i = 0; i <= minutes; i++)
		arrayHoldingMaximum[0][i] = 0L;
		for (int i = 1; i <= noOfItems; i++)
			for (int j = 0; j <= minutes; j++)
				if ((timeConsumeArray[i - 1] <= j) && (satisactionValueArray[i - 1]
						+ arrayHoldingMaximum[i - 1][j - timeConsumeArray[i - 1]] > arrayHoldingMaximum[i - 1][j])) {
					arrayHoldingMaximum[i][j] = satisactionValueArray[i - 1]
							+ arrayHoldingMaximum[i - 1][j - timeConsumeArray[i - 1]];
					backTrackArray[i][j] = 1L;
				} else {
					arrayHoldingMaximum[i][j] = arrayHoldingMaximum[i - 1][j];
					backTrackArray[i][j] = 0L;
				}
		// backtracking
		LOGGER.info("Items Selected from menu  Item    TimeConsumed    SatisfactoryValue");
		int K = minutes;
		for (int i = noOfItems; i >= 1; i--)
			if (backTrackArray[i][K] == 1) {
				System.out.printf("%5d%7d%7d\n", i, timeConsumeArray[i - 1], satisactionValueArray[i - 1]);
				K -= timeConsumeArray[i - 1];
			}
		LOGGER.info("Maximum satisfaction : " + arrayHoldingMaximum[noOfItems][minutes]);
		return arrayHoldingMaximum[noOfItems][minutes];

		

	}

	
}
