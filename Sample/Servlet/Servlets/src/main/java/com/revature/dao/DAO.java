package com.revature.dao;

import java.util.List;

public interface DAO <T>{
	 T addInstance (T newinstance);
		  List <T> getAllInstance();
		 

		void getByID(int id);
		 void  updateInstance(T updatinstance);
		
		 void  deleteInstance(T deleteinstance);

}
