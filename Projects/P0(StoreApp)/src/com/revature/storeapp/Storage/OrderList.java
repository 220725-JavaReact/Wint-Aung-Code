package com.revature.storeapp.Storage;

import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Orders;

public class OrderList {
	
	Orders[] backingArray;
	int lastIndex;
	
	
	public OrderList()
	{
		backingArray=new Orders[10];
		lastIndex=0;
	}
	public void add(Orders newOrder)
	{
		if(lastIndex==backingArray.length)
		{ // wat if the arraylist has reach ed max cap?
			int newSize=(int)(lastIndex* 1.5);
			Orders[]newBacking =new Orders[newSize];
			
			//newBacking=backingArray.clone();
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex]=newOrder;
		lastIndex++;
	}
	
	public Orders[]getAllElements()
	{
		
		return backingArray;
	}

}
