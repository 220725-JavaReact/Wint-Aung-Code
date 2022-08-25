package com.revature.servlets;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Customer;

public class MainMenu extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServerException
	{
		//res.setStatus(200);
		//res.getWriter().write(" WInt");
		System.out.println("Direct Get");
		res.setContentType("text/html");
	res.getWriter().write("<html><body><h1> Customer Login Page </h1>"
			+ " <p> Please enter username and Password !</p>"
			
			
			+"</body></html>");
	}
	
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
	{
		System.out.println("In Direct Post");
		//if we want to send a customer as part of the HTTP response,we need to package it
		resp.setContentType("application/json");
		Customer customer=new Customer( "wint","Aung","wintuser","wintpsd");
		// class  we will be using to transform our objects into JSON;
		ObjectMapper objectMapper=new ObjectMapper();
		resp.getWriter().write(objectMapper.writeValueAsString(customer));
		
	}
}
