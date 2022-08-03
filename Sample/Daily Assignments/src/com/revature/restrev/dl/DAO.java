package com.revature.restrev.dl;

import java.util.ArrayList;

public interface DAO<T> {
	 void addInstance(T newInstance);
	ArrayList<T>getAllInstances();
	 

}
