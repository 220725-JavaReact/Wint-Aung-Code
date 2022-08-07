package com.revature.storeapp.notjunit;

public class Assert {
	
	public static void equal (int actual, int expected)
	{
		if(expected!=actual) throw new AssertException();
		
	}

}
