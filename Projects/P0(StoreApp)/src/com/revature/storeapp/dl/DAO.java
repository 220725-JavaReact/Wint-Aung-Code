package com.revature.storeapp.dl;

public interface DAO<T> {
 void addInstance (T newInstance);
 
 
 
 T getByName (String UserName );
 T getUser(String UserName,String Password);
 T setUpdate(String FirstName,String LastName,String UserName,String Password,String Email);
 
     T[]getAll();
 void UpdateInstance(T updatedInstance);
 void UpdateCustInstance(T updatedCusInstance);
 }