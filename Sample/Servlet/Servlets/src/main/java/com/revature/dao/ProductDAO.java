package com.revature.dao;

import java.util.List;

import com.revature.model.Inventory;

public interface ProductDAO <T>{
	 T addInstance (T newinstance);
	
		
		  List <T> getAllInstance();
		
		 T[]getAll();

		Inventory  getByID(int id);
		 void  updateInstance(T updatinstance);
		
		 void  deleteInstance(T deleteinstance);

}
