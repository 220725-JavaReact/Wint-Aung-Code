package com.revature.storeapp.dl;

import java.util.ArrayList;
import java.util.List;

public interface PDAO <T>{
	void addInstance (T newInstance);
	 ///
	 
	 
	 T getByName (String Brand);
	 //////
	 
	     T[]getAll();
	 ///////
	     void UpdateInstance(T updatedInstance);
	////////////////////////////  dAO ////
	     void save (T obj);
	     void update (T obj);
	     void delete (String id);
	     
	    T getByID(String ID);
	    List<T>GetEverything();

}
