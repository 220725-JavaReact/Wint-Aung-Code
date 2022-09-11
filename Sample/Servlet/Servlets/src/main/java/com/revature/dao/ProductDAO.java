package com.revature.dao;

import java.util.List;

import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.model.OrderHistory;

public interface ProductDAO <T>{
	 T addInstance (T newinstance);
	
		
		  List <T> getAllInstance();
		  List<T> getAllByID(int id);

		
		 Inventory  getByID(int InventoryID,int ProductID,int StoreID,String Brand,String Category,String Store,String Location,int Price,int Quantity);
		
		 void  Upinstance(int intentoryqty);

		 void  deleteInstance(T deleteinstance);

		 
		Order deleteInstance(Integer id);


		void Upinstance(Inventory updateinstance);

		 
}
