package com.revature.dao;

import java.util.List;

import com.revature.model.Inventory;
import com.revature.model.Order;

public interface ProductDAO <T>{
	 T addInstance (T newinstance);
	
		
		  List <T> getAllInstance();
		  List<T> getAllByID(int id);

		
		void getInstance(T updateinstance);
		
		 Inventory  getByID(int InventoryID,int ProductID,int StoreID,String Brand,String Category,String Store,String Location,int Price,int Quantity);
		
		 void  deleteInstance(T deleteinstance);


		Order deleteInstance(Integer id);

		 
}
