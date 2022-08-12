package com.revature.storeapps.services;

import java.util.List;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.exception.InvalidUerException;
import com.revature.storeapp.models.Customer;
import com.revature.storeapps.util.annotations.Inject;

public class CustomerService {
	@Inject
	private final CustomerDBDAO customerDBDAO;
	
	
	
	@Inject
	public CustomerService(CustomerDBDAO customerDBDAO)
	{
		this.customerDBDAO=customerDBDAO;
	}
	
	
	
	public Customer Login(String UserName,String Password)
	{
	Customer customer= new Customer();
	List<Customer> customers=customerDBDAO.GetEverything();
	
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
		customerDBDAO.save(customer);
	}
	

	
	
	public boolean isValidUserName(String UserName)
	{
		 if (UserName.matches("^(?=[a-zA-Z0-9._]{4,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")) return true;
	        throw new InvalidUerException("Invalid username. Username needs to be 4 to 20  characters long.");
	   
	}
	
	public boolean isNotDuplicateUserName(String UserName)
	{
		List <String >userName= customerDBDAO.getAllUserName();
		if(userName.contains(userName))throw new InvalidUerException("UserName is already taken :(");
		throw new InvalidUerException("Invalid Password!!!, Please put the minimum 8 characters and one letter, one number and one special character");
	}
	public boolean isValidPassword(String Password)
	{
		if(Password.matches("^=.*[A-Az-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$"))
		return true;
		throw new InvalidUerException("Invalid Password!!,Minimum eight chracter, one letter, one number and one specail chracter");
	}
	
	private Customer isValidCredentials(Customer customer)
	{
		if(customer.getUserName()== null & customer.getPassword()==null)
		
			throw new InvalidUerException("Incorrect username and password");
			
		else if (customer.getUserName()==null) throw new InvalidUerException("Incorrect Username");
		else if (customer.getPassword()==null )throw new InvalidUerException("Incorrect Password");
		return customer;
	}
	
	
	
	

	
	

}
