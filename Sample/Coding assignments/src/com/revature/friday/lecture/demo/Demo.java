package com.revature.friday.lecture.demo;

import java.lang.reflect.Field;

public class Demo {

	private static String brand;
	private static boolean flag;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Computer computer =new Computer();
		int Price;
		computer.setPrice(Price: 1099);
		System.out.println(computer.getprice());
		
		Class comClass=Computer.class;
		
		try
		{
			Field priceField =comClass.getDeclaredField(brand:"Price");
			priceField.setAccessible(flag:true);
			priceField.set(computer, -1099);
			System.out.println(computer.getprice());
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Field[] allFields =comClass.getDeclaredFields();
		for (Field field :allFields) 
		{
			System.out.println(field.getBrand());
		}
		
		
		
	}

}
