package com.revature.pointsapp.NotJunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.revature.pointsapp.model.TeamTest;

public class TestRunner
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Class<TeamTest>obj=TeamTest.class;
		System.out.println("Running tests.....");
		
		for(Method method:obj.getDeclaredMethods())
		{
			if(method.isAnnotationPresent(Test.class))
			{
				
				try {
					System.out.println("Test method: " + method.getName());
					method.invoke(obj.newInstance());
					System.out.println("Test Passed");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					//if this get thwown it means our test failed 
					System.out.println("Test Failed"+e.getTargetException());
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
		
	 }

}
