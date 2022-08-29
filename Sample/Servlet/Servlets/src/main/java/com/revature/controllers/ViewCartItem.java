package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Customer;

public class ViewCartItem extends HttpServlet{
	int addcartproduct=0;
	Cookie c=null;
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
		
		resp.setContentType( ("text/html"));
		PrintWriter pw=resp.getWriter();
		try {
			
			c=new Cookie(req.getParameter("ProductID"),"1");
			resp.addCookie(c);
			pw.print("Product added into your cart" );
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	

}
