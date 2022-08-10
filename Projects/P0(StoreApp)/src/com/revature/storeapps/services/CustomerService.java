package com.revature.storeapps.services;

import java.util.List;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.exception.InvalidUerException;
import com.revature.storeapp.models.Customer;
import com.revature.storeapps.util.annotations.Inject;

public class CustomerService {
	@Inject
	private final CustomerDBDAO customerDBAO;
	
	@Inject
	public CustomerService(CustomerDBDAO customerDBAO)
	{
		this.customerDBAO=customerDBAO;
	}
	
	public Customer Login(String UserName,String Password)
	{
	Customer customer= new Customer();
	List<Customer> customers=customerDBAO.getAll();
	
	for (Customer u:customers)
	{
		if(u.getUserName().equals(UserName))
		{
			customer.setCustomerID(u.getCustomerID());
			customer.setUserName(u.getUserName());
			
			if(u.getPassword().equals(Password))
			{
				customer.setPassword(u.getPassword());
				break;
			}
		}
		if(u.getPassword().equals(Password))
		{
			customer.setPassword(u.getPassword());
		}
	}
	return isValidCredentials(customer);
	}
	public void register(Customer customer)
	{
		customerDBAO.save(customer);
	}
	public boolean isValidUserName(String UserName)
	{
		if(UserName.matches("^(?=[a-zA-Z0-9._]{8,18}$)(?!.*[_.]{2})[^_.].*[^_.]$")) 
		return true;
		
		throw new InvalidUerException("Invalid User Name .User name needs to be 8- 18 characters long.");
		
	}
	
	public boolean isNotDuplicateUserName(String UserName)
	{
		List <String >userName= customerDBAO.get
	}
	
	
	

}
