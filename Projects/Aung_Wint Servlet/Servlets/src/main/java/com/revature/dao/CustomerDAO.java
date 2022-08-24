package com.revature.dao;

import java.util.List;

public interface CustomerDAO <T>{
	public T addInstance (T newinstance);
	
	//T [] getAll();
	public List <T> getAllInstance();

	
	public T updateInstance(T updatinstance);
	
	public T deleteInstance(T deleteinstance);
	

}
