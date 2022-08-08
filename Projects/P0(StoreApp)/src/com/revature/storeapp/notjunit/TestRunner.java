package com.revature.storeapp.notjunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.revature.storeapp.models.ProductTest;
import com.revature.storeapp.notjunit.annotation.Test;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Class<ProductTest> obj=ProductTest.class;
   System.out.println("Running Test........");
   
   for (Method method:obj.getDeclaredMethods())
   {
	   if (method.isAnnotationPresent(Test.class))
	   {
		   try {
			   System.out.println("Testing Method:" +method.getName());
			method.invoke(obj .newInstance());
			System.out.println("Test Passed!!!!!!!");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			//if this gets thrown it means our test failed
			System.out.println("Test Failed"+ e.getTargetException());
			e.printStackTrace();
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  
	   }
   }
	}

	private static Object newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
