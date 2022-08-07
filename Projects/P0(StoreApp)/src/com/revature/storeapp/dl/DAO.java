package com.revature.storeapp.dl;

public interface DAO<T> {
 void addInstance (T newInstance);
 
 
 
 T getByName (String UserName);
 
     T[]getAll();
 void UpdateInstance(T updatedInstance);
 }