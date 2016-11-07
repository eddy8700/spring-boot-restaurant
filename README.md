# SatisfactionCalculator

#Problem Addressed : Gordon Ramsey, a very smart guy, like seating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format:
 
[t][Number of items on menu]
[amount of satisfaction from eating dish 1][time taken for dish 1]
[amount of satisfaction from dish 2][time taken for dish 2]

Requirements
1.Java 1.7 or higher
2.Maven installed on classpath

Build the program following the below steps
1. Rum mvn install in restaurant-api
2.Run mvn install in restaurant-impl
3.Run mvn install in restaurant-rest

Controller endpoint is exposed in restaurant-rest Running mvn install on it will alo run the test case for you.
Application will run on port 8111

Rest url :http://localhost:8111/restaurant-service/findMaximumSatisfaction  (GET call)

This method will invoke the file from classpath resource
Name of the file is configurable and is specified in the properties file

This is will delegate the call to the restaurant-impl which will invoke the following method
buildMaximumSatisfactionForAGivenTime(Integer minutes, Integer[] timeConsumeArray,Integer[] satisactionValueArray, Integer noOfItems)
1. minutes-no of minutes a user can eat.
2. timeConsumeArray-array of all elements consisting  of time taken to eat a particluar dish.
3. satisactionValueArray-array of all elements consisting of satisfacation value achieved in eating a particluar dish.
4. noOfItems-No of items or dish the user can a try in a particluar sitting.

Approach followed for achieving maximum satisfaction value
Used the knapsack algorithm to achieve maximum satisfacation value
Initially created the two dimensional array of items+1 and minutes+1 and filled it with 0's
For each steps
      1. find the solutions to maximize satisfacation value  and then iteratively build the solution for original problem. 
	  2. we check each dish and see whether we are getting the better satisfacation value 
	    if we include this dish in the knapsack, if yes, then take that dish. 
	     If not, then skip this dish.
		 
		 Finally, we backtrace the array holding maximum satisfacation value and print and return









