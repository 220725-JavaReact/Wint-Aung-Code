package com.revature.storeapp.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.Inventory;

public interface PDAO <T>{
	void addInstance (T newInstance);
	 ///
	 
	 
	 T getByName (String Brand);
	 T getByInvID(String InventoryID);
	 //////
	 
	     T[]getAll();
	 ///////
	 //    void UpdateInstance(T obj);
	////////////////////////////  dAO ////
	     void save (T obj);
	    
	    		 void delete (String id);
	     
	    T getByID(String ID);
	    List<T>GetEverything();


		void update(Inventory in);


		


		void UpdateInstance(int Quantity);

}
