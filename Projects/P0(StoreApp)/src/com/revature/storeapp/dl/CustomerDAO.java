package com.revature.storeapp.dl;

import com.revature.storeapp.Storage.CustomerStorage;
import com.revature.storeapp.models.Customer;

public class CustomerDAO implements DAO<Customer> {

	@Override
	public void addInstance(Customer newInstance) {
		// TODO Auto-generated method stub
		//to add a customer somewhere i need a place to store it
		CustomerStorage.customerlist.add(newInstance);
	}

	@Override
	public Customer getByName(String FirstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer[] getAll() {
		// TODO Auto-generated method stub
		return CustomerStorage.customerlist.getAllElements();
	}
	

}
