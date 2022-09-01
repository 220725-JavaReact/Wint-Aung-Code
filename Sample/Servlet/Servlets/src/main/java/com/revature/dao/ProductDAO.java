package com.revature.dao;

import java.util.List;

public interface ProductDAO <T>{
	 T addInstance (T newinstance);
	
		
		  List <T> getAllInstance();
		
		 T[]getAll();

		void getByID(int id);
		 void  updateInstance(T updatinstance);
		
		 void  deleteInstance(T deleteinstance);

}
