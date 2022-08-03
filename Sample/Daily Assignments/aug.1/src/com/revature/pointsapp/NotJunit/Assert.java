package com.revature.pointsapp.NotJunit;

public class Assert {

	public static void equals(int expected , int actual)
	{
		if(expected!=actual)throw new AssertException();
	}
	public static void WillThrow(Class exceptionType,Runnable testMethod)
	
	{
		try 
		{
			testMethod.run();
			throw new AssertException();
		}
		catch(Exception ex)
		{
			if(!ex.getClass().equals(exceptionType)) throw new AssertException();
		}
	}
	
}
