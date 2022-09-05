package com.revature.storage;

import com.revature.model.Customer;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.model.Product;

public class CartList {
	Inventory[] backingArray;
	int lastIndex;
	
	
	public CartList()
	{
		backingArray=new Inventory[10];
		lastIndex=0;
	}
	public void add(Inventory newInstance)
	{
		if(lastIndex==backingArray.length)
		{ // wat if the arraylist has reach ed max cap?
			int newSize=(int)(lastIndex* 1.5);
			Inventory[]newBacking =new Inventory[newSize];
			
			//newBacking=backingArray.clone();
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex]=newInstance;
		lastIndex++;
	}
	
	public Inventory[]getAllElements()
	{
		
		return backingArray;
	}
	
}
