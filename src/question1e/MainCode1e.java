/*
 *  Bonita Faye Vincent
 *  AIT642
 *  Spring 2016
 *  Exam II
 *  Question 1e.
  */
package question1e;

import org.junit.*;

import static org.junit.Assert.*;


public class MainCode1e {
	
	/**
	 * The main method.
	 * Section 1.2 # for the findLast method
	 * 
	 * This program will return the index of the last element in x that equal y
	 *  if x=null it will throw NullPointerException 
	  *
	 * @param args the arguments
	 */
	
	public static void main(String[] args) {
	
		//Sets up an ArrayList, value for y, and results variable
     	int[] xArray = null;
       	int valueY = 0; 
	   	int indexResult; 
	   	
	   	// calls the function findLast to search for the last value in xArray    	
     
	   	indexResult = findLast(xArray,valueY);
	   	
	   	System.out.println("This is indexResult " + indexResult);
		 
	}

	public static int findLast(int[] arrayX, int yValue)throws NullPointerException
	{
		int resultIndex = 0;
		
		// searches from the last to the first value for the value =y
		for (int i = arrayX.length - 1; i >= 0; i--){
			if (arrayX[i] == yValue){
				resultIndex = i;
				return resultIndex;
			}
		}		
		
		return -1;
	
	}
	
	// Test if the code finds the last value of y in arrayX
	@Test
	public void testFindLast_1()
		throws Exception {
		int[] arrayX = new int[] {2, 3, 5};
		int yValue = 2;

		int result = MainCode1e.findLast(arrayX, yValue);

		// add additional test code here
		assertEquals(0, result);
	}
	
	// Test if exception is thrown if arrayX is null
	@Test (expected = NullPointerException.class)
	public void testFindLast_2()
		throws Exception {
		int[] arrayX = null;
		int yValue = 2;

		int result = MainCode1e.findLast(arrayX, yValue);

		// add additional test code here
		assertEquals(0, result);
	}
	
	
}
