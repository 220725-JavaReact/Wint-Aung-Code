package com.revature.controllers;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDBDAO;
import com.revature.dao.ProductDBDAO;
import com.revature.model.Customer;
import com.revature.model.Product;

public class OrderController extends HttpServlet {

	private static CustomerDAO<Customer> customerDAO= new CustomerDBDAO() ;
	private static CustomerDAO<Product> productDAO= new ProductDBDAO() ;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServerException
	{
		
		
List<Product> listofProduct=productDAO.getAllInstance();
		
		
		for(Product product : listofProduct)
		{
		resp.getWriter().println("============================ ");
		//resp.getWriter().println(customer.getCustomerID());
		resp.getWriter().println("ProductID  : ["+product.getProductID()+"]");
		resp.getWriter().println("Name       : ["+product.getProductName()+"]");
		resp.getWriter().println("Category   : ["+product.getCategory()+"]");
		resp.getWriter().println("Price      : ["+product.getPrice()+"]");
		resp.getWriter().println("Quantity   : ["+product.getQuantity()+"]");
		
		}
		
	}
	
 @Override
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServerException
	{
	 //unpacking form elements sent via request
	  String fname=req.getParameter("FirstName");
	  String lname=req.getParameter("LastName");
	  String username=req.getParameter("UserName");
	  String password=req.getParameter("Password");
	  
	  Customer customer=new Customer(fname,lname,username,password);
	  
	  HttpSession session=req.getSession();
	  session.setAttribute("the-customer", customer);
	  res.getWriter().write("The customer firstname :" +fname+ "lastName:" +lname+ "is on the loose...." );
	  
	  
	}
	
}
