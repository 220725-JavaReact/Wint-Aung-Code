package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
	protected void doGet(HttpServletRequest req,HttpServletResponse response)throws IOException,ServletException
	{ //TLDR- will 
		final String URI=req.getRequestURI().replace("/Servlets/", "");
		
		
		String jsonString;
		switch (URI)
		{
		case "customer":
			response.getWriter().println("I am getting a specific custmomer");
		//logger.log(LogLevel.info, "Retrieve a customer ");
		 
//			
			
			
			break;
		case "allcustomer":
		
			
			
			
			
			
			
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			
				out.print("<a href='Home.html'>Go Back</a>");
				
				out.print("<style>"//
						+ "td,th{padding:10px 20px;}"
						+ "body{font-family:arial;}"
						+ "table{border:1px solid black;text-align:center; padding:20px;margin-top:50px;background-color:#cce5ff;}"
						+ "a{text-decoration:none;border:1px solid black;padding:10px 10px;}"
						+ "button{  background-color:#3949ab;color:#FFF;padding:12px 12px;border-radius:8px;font-size:1.18em;display:inline-block;}"
						+ "a:hover{color:red;}"
						+ "</style><center>"
						+ "<table style= width:100%>"
						+ "<tr>"
						

							
							+ "<th>FistName</td>"
							+ "<th>LastName</th>"
							
							+ "<th>UserName</th>"
							+ "<th>Password</th>"
						);					

				
				
				
			//displaying the result of our dao logics
		List<Customer> listofCustomer=customerDAO.getAllInstance();
				for(Customer customer : listofCustomer)
		{
			
			
			
			
		response.getWriter().println("============================ ");
		//resp.getWriter().println(customer.getCustomerID());
		response.getWriter().println("<tr><td>"+customer.getFirstName()+"</td>");
		response.getWriter().println("<td>"+customer.getLastName()+"</td>");
		response.getWriter().println("<td>"+customer.getUserName()+"</td>");
		response.getWriter().println("<td>"+customer.getPassword()+"</td>");		
		response.getWriter().println("============================ ");
		}
				out.println("</table></center>");
				
				out.println("</body></html>");
			
		
		
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