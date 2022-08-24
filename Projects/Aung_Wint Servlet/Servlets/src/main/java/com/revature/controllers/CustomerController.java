package com.revature.controllers;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDBDAO;
import com.revature.model.Customer;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class CustomerController extends HttpServlet{

	/**
	 * this method is reponsible with handling all the get require
	 * if you need multiple get requsts from the same controllers>
	 * 
	 */
	private static CustomerDAO<Customer> customerDAO= new CustomerDBDAO() ;
	private static Logger logger=Logger.getLogger();
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException
	{ //TLDR- will 
		final String URI=req.getRequestURI().replace("/Servlets/", "");
		
		
		String jsonString;
		switch (URI)
		{
		case "customer":
			resp.getWriter().println("I am getting a customer");
		//logger.log(LogLevel.info, "Retrieve a customer ");
		
//			
			break;
		case "allcustomer":
			resp.getWriter().println("I'm getting all customer");
			//displaying the result of our dao logics
		List<Customer> listofCustomer=customerDAO.getAllInstance();
		
		
		for(Customer customer : listofCustomer)
		{
		resp.getWriter().println("============================ ");
		//resp.getWriter().println(customer.getCustomerID());
		resp.getWriter().println("FirstName  : "+customer.getFirstName());
		resp.getWriter().println("LastName   : "+customer.getLastName());
		resp.getWriter().println("UserName   : "+customer.getUserName());
		resp.getWriter().println("Password   : "+customer.getPassword());		
		resp.getWriter().println("============================ ");
		}
		
		
		break;
		default:
		break;
		
		
	}//resp.getWriter().println(URI);
}
	}
