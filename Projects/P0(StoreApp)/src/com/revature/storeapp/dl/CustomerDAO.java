package com.revature.storeapp.dl;

import java.util.List;

import com.revature.storeapp.Storage.CustomerStorage;
import com.revature.storeapp.models.Customer;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

public class CustomerDAO implements DAO<Customer> {
	private static Logger logger=Logger.getLogger();

	@Override
	public void addInstance(Customer newInstance) {
		// TODO Auto-generated method stub
		//to add a customer somewhere i need a place to store it
		CustomerStorage.customerlist.add(newInstance);
		logger.log(LogLevel.info,"Adding a new customer "+newInstance.getUserName());
	}

	@Override
	public Customer getByName(String UserName) {
		// TODO Auto-generated method stub
		for (Customer customer:getAll())
		{
			if(customer.getUserName().equals(UserName)) {
				logger.log(LogLevel.info,"Customer" +UserName+ "Found!");
			}
			return customer;
		}
		logger.log(LogLevel.warning,"Customer" +UserName+"Not Found!");
		return null;
	}

	@Override
	public Customer[] getAll() {
		// TODO Auto-generated method stub
		logger.log(LogLevel.info,"Getting all customers"
				);
		return CustomerStorage.customerlist.getAllElements();
	}

	@Override
	public void UpdateInstance(Customer updatedInstance) {
		// TODO Auto-generated method stub
		Customer[] allCustomer=getAll();

		for(int i=0;i< allCustomer.length;i++)
		{
			if(allCustomer[i].getUserName().equals(updatedInstance.getUserName()));
			allCustomer[i]=updatedInstance;
			logger.log(LogLevel.info,"Customer" +updatedInstance.getCustomerID()+"Successfully updated");
			break;
		}
	}

	

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> GetEverything() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Customer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getUser(String UserName, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer setUpdate(String FirstName, String LastName, String UserName, String Password, String Email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateCustInstance(Customer updatedCusInstance) {
		// TODO Auto-generated method stub
		
	}
	
	

}
