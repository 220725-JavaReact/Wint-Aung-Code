package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Order;

public class AddtToCart extends HttpServlet{
	
	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException
	{
		try(PrintWriter out=response.getWriter())
		{
			ArrayList<Order> cartlist=new ArrayList<>();
		}
	}

}
