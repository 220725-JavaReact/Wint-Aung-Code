package com.revature.storeapp.dl;

import java.util.List;

import com.revature.storeapp.models.Customer;

public interface DAO<T> {
 void addInstance (T newInstance);
 
 
 
 T getByName (String UserName );
 T getUser(String UserName,String Password);
 T setUpdate(String FirstName,String LastName,String UserName,String Password,String Email);
 
     T[]getAll();
    
 void UpdateInstance(T updatedInstance);
 
 void UpdateCustInstance(T updatedCusInstance);
 
////////////////////////////////
 void save (T obj);
  void update (T obj);
  void delete (String id);
  
 T getByID(String ID);
 List<T>GetEverything();




 
 
 }