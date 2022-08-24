 package com.revature.bl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Condition;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDBDAO;
import com.revature.model.Customer;

public class CustomerService {
	
	private CustomerDAO<Customer>customerDAO;
	public CustomerService(CustomerDAO<Customer>customerDAO)
	{
		this.customerDAO=customerDAO;
	}
	public CustomerService()
	{
		this.customerDAO=new CustomerDBDAO();
		
	}
	
    public List <Customer>getAllCustomer(){
    	return customerDAO.getAllInstance();
    }
    public Customer getCustomerbyID(int id)
    {
    	List<Customer> listofCustomer= getAllCustomer();
    	Optional<Customer> foundcustomer=listofCustomer.stream()
    			.filter(customer -> customer.getCustomerID()==id)
    			.findFirst();
    	if(foundcustomer.isPresent())
    	{
    		return foundcustomer.get();
    		
    	}
    	else 
    	{
    		Customer noCust=new Customer();
    		noCust.setFirstName("No customer was found");
    	
    		return noCust;
    	}
    }
    
}
