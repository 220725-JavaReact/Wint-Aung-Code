package com.revature.restrev.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.restrev.exception.InvalidRatingException;

class ResturantTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test // this annotation the compiler that this is a junit test 
	void setRatingShouldSet()  
	{
	//arrange
	//create a dummy restaurant
		Restaurant test=new Restaurant();
		//inittialize a test value for the rating
		int testRating =3;
		
		//act
		//set the rating
		
		test.setRating(testRating);
		
	//assert that the expected rating value is the same as actual rating
		assertEquals(testRating,test.getRating());
		
		}
	
	@Test	
	void setRatingShouldThrowException()
	{
		//arrange
		//create a dammy restaurant
	Restaurant test=new Restaurant();
	int testRating =6;
	
		//act and assert that the same as actual things
	 //assertThrows(Exception.class,() ->test.setRating(testRating));
	 assertThrows(InvalidRatingException.class,() -> test.setRating(testRating));
		
	}
	
	

}
