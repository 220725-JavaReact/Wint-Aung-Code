package com.revature.storeapp.dl;

import java.util.ArrayList;

public interface PDAO <T>{
	void addInstance (T newInstance);
	 ///
	 
	 
	 T getByName (String Brand);
	 //////
	 
	     T[]getAll();
	 ///////
	     void UpdateInstance(T updatedInstance);
	

}
