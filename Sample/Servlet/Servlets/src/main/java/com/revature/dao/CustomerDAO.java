package com.revature.dao;

import java.util.List;

public interface CustomerDAO <T>{
	 T addInstance (T newinstance);
	
	//T [] getAll();
	  List <T> getAllInstance();

	void getByID(int CustomerID,String UserName,String Password);
	 void  updateInstance(T updatinstance);
	
	 void  deleteInstance(T deleteinstance);
	

}
