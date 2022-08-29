package com.revature.controllers;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
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
			resp.getWriter().println("I am getting a specific custmomer");
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
@Override 

	
	 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServerException
	{
	  
	String fname=req.getParameter("FirstName");
	  String lname=req.getParameter("LastName");
	  String username=req.getParameter("UserName");
	  String password=req.getParameter("Password");
	  
	  Customer customer=new Customer(fname,lname,username,password);
	  
	  HttpSession session=req.getSession();
	  session.setAttribute("the-customer", customer);
	  res.getWriter().write("The customer firstname :" +fname+ "     lastName:" +lname+"UserName:"+username+" was register successfully...." );
	  
	 customerDAO.addInstance(customer);
		
	
	}
}