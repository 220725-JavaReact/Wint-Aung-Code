package com.revature.storage;

import com.revature.model.Inventory;

public class CustomerList {
	Inventory[] backingArray;
	int lastIndex;
	
	
	public CustomerList()
	{
		backingArray=new Inventory[5];
		lastIndex=0;
	}
	public void add(Inventory newCustomer)
	{
		if(lastIndex==backingArray.length)
		{ // wat if the arraylist has reach ed max cap?
			int newSize=(int)(lastIndex* 1.5);
			Inventory[]newBacking =new Inventory[newSize];
			
			//newBacking=backingArray.clone();
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex]=newCustomer;
		lastIndex++;
	}
	
	public Inventory[]getAllElements()
	{
		
		return backingArray;
	}
}
