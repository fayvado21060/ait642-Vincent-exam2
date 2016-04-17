/*
 *  Bonita Faye Vincent
 *  AIT642
 *  Spring 2016
 *  Exam II
 *  Question 1
  */
package question1;

import java.util.ArrayList;

import org.junit.*;

import static org.junit.Assert.*;

public class MainCode {
	
		/**
		 * The main method.
		 * 
		 * This program will compare two Array Lists (aList and bList)
		 *  and place values existing in
		 * both list into a third Array list (intersectList)
		 *
		 * @param args the arguments
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			
			// Sets up the two ArrayList with values
			
			ArrayList<String> aList = new ArrayList<String>();
			aList.add("this");
			aList.add("is");
			aList.add("a");
			aList.add("simple");
			aList.add("test");
			aList.add("to");
			aList.add("do");
			
			ArrayList<String> bList = new ArrayList<String>();
			bList.add("to");
			bList.add("do");
			bList.add("this");
			bList.add("test");
			bList.add("is");
			bList.add("very");
			bList.add("quick");
			bList.add("and");
			bList.add("simple");
			
			//  This sets up the ArrayList that contain the values found in
			//  both list
			
			ArrayList<String> intersectList = new ArrayList<String>();
			
			// prints out the value of ArrayList a
			System.out.println("This is the value of aList ");
					
			for (int i = 1; i <= aList.size(); ++i){
				System.out.println(aList.get(i-1));
						
			}
			// prints out the value of ArrayList b
			System.out.println();
			System.out.println("This is the value of bList ");
			
			for (int i = 1; i <= bList.size(); ++i){
				System.out.println(bList.get(i-1));
			}
			System.out.println();
			
			// this call the function intersection and places the results
			// in the intersectList and prints out the values
			
			intersectList = intersection(aList,bList);
			
			
			//prints out values that are contained in both list
			
			System.out.println();
			System.out.println("This is what is contained in intersectList ");
			for (int j = 1; j <= intersectList.size(); ++j){
				System.out.println(intersectList.get(j-1));
			}
			
		}
		
		// this is the function intersection call by the main method
		// it evaluates the secondList to see if values from the first list are present
		// if so it places it a results list
		
		public static ArrayList<String>
	              intersection(ArrayList<String> firstList, ArrayList<String> secondList){
			
		// defines the ArrayList to accept the result of an intersection between the 
		// two ArrayList	
		        
			 ArrayList<String> resultsList = new ArrayList<String>();
				
				for (int i = 1; i <= secondList.size(); i++) {
					boolean inThere = firstList.contains(secondList.get(i-1));
					
					// this code was added to remove duplicates from the results
					// and if statement was modified to handle duplicate in list
					// && (duplicateValue == false)
					
					boolean duplicateValue = resultsList.contains(secondList.get(i-1));
					
					
					if ((inThere == true) && (duplicateValue == false))
					{
				        resultsList.add(secondList.get(i-1));
				    } 
					else 
					{
			        	System.out.println("This is not contained in both list " + secondList.get(i-1));
			        } 
				}
					return resultsList;
	    }
		
		// This test was created to check if function was running correct it checks the result size
		// and if the index are catching the first and last result correctly 
		
		
		@Test
		public void testIntersection_1()
			throws Exception {
			ArrayList<String> firstList = new ArrayList<String>();
			firstList.add("this");
			firstList.add("is");
			firstList.add("a");
			firstList.add("simple");
			firstList.add("test");
			firstList.add("to");
			firstList.add("do");
			
			ArrayList<String> secondList = new ArrayList<String>();
			secondList.add("to");
			secondList.add("do");
			secondList.add("this");
			secondList.add("test");
			secondList.add("is");
			secondList.add("very");
			secondList.add("quick");
			secondList.add("and");
			secondList.add("simple");
			
			ArrayList<String> result = MainCode.intersection(firstList, secondList);

			// shows that result file is correct and index is correct
			
			assertNotNull(result);
			assertEquals(6, result.size());
			assertEquals("to", result.get(0));
			assertEquals("do", result.get(1));
			assertEquals("this", result.get(2));
			assertEquals("test", result.get(3));
			assertEquals("is", result.get(4));
			assertEquals("simple", result.get(5));
			assertTrue(result.contains("simple"));
		}
		
		// This test was created to check if function was running correct it checks the result size
		// and code if the if statement results in a false condition when a value is not present in both
		// ArrayList
		
		
		@Test
		public void testIntersection_2()
			throws Exception {
			ArrayList<String> firstList = new ArrayList<String>();
			firstList.add("this");
			firstList.add("is");
			firstList.add("a");
			ArrayList<String> secondList = new ArrayList<String>();
			secondList.add("to");
			secondList.add("do");
			secondList.add("this");
			secondList.add("test");
			secondList.add("is");
			secondList.add("very");
			secondList.add("quick");
			secondList.add("and");
			secondList.add("simple");

			ArrayList<String> result = MainCode.intersection(firstList, secondList);

			// add additional test code here
			assertNotNull(result);
			assertEquals(2, result.size());
			assertFalse(result.contains("a"));
		}	
		
		// This test was created to check if function was running correct it checks the result size
		// and if the index are catching the first and last result correctly if ArrayList are null
				
		@Test
		public void testIntersection_3()
			throws Exception {
			ArrayList<String> firstList = new ArrayList();
			ArrayList<String> secondList = new ArrayList();

			ArrayList<String> result = MainCode.intersection(firstList, secondList);

			// add additional test code here
			assertNotNull(result);
			assertEquals(0, result.size());
		}
		
		// This test was created to check if function was running correct it checks the result size
		// and code if the if statement results in a false condition when values are not present in both
		// ArrayList
				
				
				@Test
				public void testIntersection_4()
					throws Exception {
					ArrayList<String> firstList = new ArrayList<String>();
					firstList.add("bats");
					firstList.add("balls");
					firstList.add("pucks");
					ArrayList<String> secondList = new ArrayList<String>();
					secondList.add("to");
					secondList.add("do");
					secondList.add("this");
					secondList.add("test");
					secondList.add("is");
					secondList.add("very");
					secondList.add("quick");
					secondList.add("and");
					secondList.add("simple");

					ArrayList<String> result = MainCode.intersection(firstList, secondList);

					// add additional test code here
					assertNotNull(result);
					assertEquals(0, result.size());
					assertFalse(result.contains("bats"));
				}	
		
				// This test was created to check if function work if the one is case (lower and upper) 
				// are different will is still id
				//
					    @Test
						public void testIntersection_5()
							throws Exception {
							ArrayList<String> firstList = new ArrayList<String>();
							firstList.add("bats");
							firstList.add("balls");
							firstList.add("pucks");
							ArrayList<String> secondList = new ArrayList<String>();
							secondList.add("BATS");
							secondList.add("BALLS");
							secondList.add("PUCKS");
							secondList.add("test");
							secondList.add("is");
							secondList.add("very");
							secondList.add("quick");
							secondList.add("and");
							secondList.add("simple");

							ArrayList<String> result = MainCode.intersection(firstList, secondList);

							// add additional test code here
							assertNotNull(result);
							assertEquals(0, result.size());
							assertFalse(result.contains("bats"));
						}	
					    
					 // This test was created to check if function works if the same value is in  
					// list multiple times
				 	//
							    @Test
								public void testIntersection_6()
									throws Exception {
									ArrayList<String> firstList = new ArrayList<String>();
									firstList.add("bats");
									firstList.add("balls");
									firstList.add("pucks");
									ArrayList<String> secondList = new ArrayList<String>();
									secondList.add("bats");
									secondList.add("bats");
									secondList.add("bats");
									secondList.add("bats");
									secondList.add("bats");
									
									ArrayList<String> result = MainCode.intersection(firstList, secondList);

									// add additional test code here
									assertNotNull(result);
//									assertEquals(0, result.size());
									assertTrue(result.contains("bats"));
								}	
}

	


