package com.revature.dao;

import java.util.List;

public interface ProductDAO <T>{
	 T addInstance (T newinstance);
		
		//T [] getAll();
		  List <T> getAllInstance();
		 

		void getByID(int ProductID);
		 void  updateInstance(T updatinstance);
		
		 void  deleteInstance(T deleteinstance);

}
