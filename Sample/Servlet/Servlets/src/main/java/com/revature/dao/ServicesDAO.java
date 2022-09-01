package com.revature.dao;

import java.util.List;

public interface ServicesDAO<T> {
	public T addInstance(T instance);
	
	
	
	
	public List<T>getAllInstance();
	public T updateInstance(T instance);
	public T DeleteInstance(T instance);
 

}
