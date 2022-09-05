package com.revature.dao;


import com.revature.model.Inventory;

import com.revature.storage.CartStorage;


public class InventoryTemp {

	public void addInstance(Inventory newInstance) 
	{
		CartStorage.cartedlist.add(newInstance);
		}
	
	
	public Inventory[] getAll() {
			
		return CartStorage.cartedlist.getAllElements();
	}
}
