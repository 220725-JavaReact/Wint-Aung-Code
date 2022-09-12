package com.revature.tests;


public class Assert {

	
	public static void equal (double expected, double actual)
	{
		if(expected!=actual) throw new AssertException();
		
	}
	public static void willThrow(Class exceptionType,Runnable testMethod)
	{
		try 
		{
			testMethod.run();
			throw new AssertException();
		}
		catch(Exception ex)
		{
			if(!ex.getClass().equals(exceptionType))throw new AssertException();
		}
	}
}
