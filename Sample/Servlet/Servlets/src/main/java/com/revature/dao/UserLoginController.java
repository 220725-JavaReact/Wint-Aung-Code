package com.revature.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Customer;
import com.revature.util.Logger;

public class UserLoginController extends HttpServlet {
	private static CustomerDAO<Customer> customerDAO= new CustomerDBDAO() ;
	private static Logger logger=Logger.getLogger();
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServerException
	{
		resp.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=resp.getWriter())
		{
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Log In Page </title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>User Login at " + req.getContextPath()+"</h1>");
			out.println("</body>");
			out.println("</html>");
			}
	
	
	}
	
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String Name =req.getParameter("UserName");
		String Password=req.getParameter("Password");
		
		if(LoginDBDAO.validate(Name, Password))
			resp.sendRedirect("Home.html");
		
		else 
		{
			out.print("Sorry username / password error");
			
			//res.sendRedirect("Home.html");
		}
	}
	

}
