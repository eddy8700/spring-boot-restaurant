# SatisfactionCalculator

#Problem Addressed : Gordon Ramsey, a very smart guy, like seating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format:
 
[t][Number of items on menu]
[amount of satisfaction from eating dish 1][time taken for dish 1]
[amount of satisfaction from dish 2][time taken for dish 2]

#Assumptions Made
The same algo / program has been written taking into consideration that 
1. t can be in minutes
2. t can be in seconds

#Algorithmic Approach for Calculation
Greedy Approach has been followed to calculate the same. We need to get the maximum satisfaction in the given time from certain number of dishes which can be possible by choosing the dish which has maximum satisfaction in minimum time.
There are so many dishes which might have approximate numbers for the satisfaction and the minimum time. In order to decide between the both we need to understand their satisfaction in time ratio which is simply as

SatisfactionInTimeRatio = [Satisfaction Value]/[Time]  

#Input
Input  to the program contains the three things :
1. The time to eat
2. The array of time Consumption
3. The array of satisfaction value
4. The no of items.

Output: Maximum Satisfaction value with comments

#Steps to Create the Same:
1. Create a new Maven Project
2. Configure the Project as a Spring Boot Application by adding dependcies for the boot starter.
3. Add Dependencies for the test starter which would help to run the junit test cases.


#Steps to the Run the same:
1. Run the application by clicking on the file Application.java and Run as Application.
2. Output can be seen on the console.
3. To Run the test cases: 

i) Open the Command Prompt on the Project Working Directory and run the Maven Command : mvn clean test
ii)To Run Individual Test Files , Click on Files having pattern *Tests.java and run as JUNIT Tests.

