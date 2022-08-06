package com.revature.storeapp.dl;

public interface DAO<T> {
 void addInstance (T newInstance);
 
 
 T getByName (String FirstName);
 
     T[]getAll();
}

