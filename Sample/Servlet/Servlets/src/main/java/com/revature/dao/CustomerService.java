
package com.revature.dao;

import java.util.List;
import java.util.Optional;

import com.revature.model.Customer;

public class CustomerService {

	private ServicesDAO<Customer>customerDAO;
	
	public CustomerService(ServicesDAO<Customer>customerDAO)
{
		this.customerDAO=customerDAO;
	}
	
	public List<Customer>getAllCustomer()
	
	{
		return customerDAO.getAllInstance();
	}
	public Customer GetbyUserName(String UserName)
	{
		List<Customer> listofCustomer=getAllCustomer();
		Optional<Customer> foundCustomer=listofCustomer.stream()
				.filter(customer -> customer.getUserName()==UserName)
				.findFirst();
		if(foundCustomer.isPresent())
		{
			return foundCustomer.get();
		}
		else {
			Customer nocustomer=new Customer();
			nocustomer.setUserName("No Customer was found");
			
			return nocustomer;
		}
	}
}

