package com.revature.storeapp.Storage;

import com.revature.storeapp.models.Customer;

public class CustomerList {

	Customer[] backingArray;
	int lastIndex;
	
	
	public CustomerList()
	{
		backingArray=new Customer[5];
		lastIndex=0;
	}
	public void add(Customer newCustomer)
	{
		if(lastIndex==backingArray.length)
		{ // wat if the arraylist has reach ed max cap?
			int newSize=(int)(lastIndex* 1.5);
			Customer[]newBacking =new Customer[newSize];
			
			//newBacking=backingArray.clone();
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex]=newCustomer;
		lastIndex++;
	}
	
	public Customer[]getAllElements()
	{
		
		return backingArray;
	}
}
