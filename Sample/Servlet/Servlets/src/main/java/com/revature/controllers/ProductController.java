package com.revature.controllers;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Customer;

public class ProductController {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServerException
	{
		Customer customer=new Customer("Wint","Aung","wintusersession", "wintpasswordsession");
		
		HttpSession session=req.getSession();
		session.setAttribute("the-customer", customer);
		res.getWriter().write("Megamind is one the loose");
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
