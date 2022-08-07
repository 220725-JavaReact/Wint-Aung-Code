package com.revature.storeapp.dl;

public interface PDAO <T>{
	void addInstance (T newInstance);
	 
	 
	 
	 T getByName (String Brand);
	 
	     T[]getAll();
	 void UpdateInstance(T updatedInstance);

}
