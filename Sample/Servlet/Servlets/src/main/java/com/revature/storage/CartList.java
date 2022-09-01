package com.revature.storage;

import com.revature.model.Customer;
import com.revature.model.Order;
import com.revature.model.Product;

public class CartList {
	Order[] backingArray;
	int lastIndex;
	
	
	public CartList()
	{
		backingArray=new Order[10];
		lastIndex=0;
	}
	public void add(Order newProduct)
	{
		if(lastIndex==backingArray.length)
		{ // wat if the arraylist has reach ed max cap?
			int newSize=(int)(lastIndex* 1.5);
			Order[]newBacking =new Order[newSize];
			
			//newBacking=backingArray.clone();
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex]=newProduct;
		lastIndex++;
	}
	
	public Order[]getAllElements()
	{
		
		return backingArray;
	}
	
}
