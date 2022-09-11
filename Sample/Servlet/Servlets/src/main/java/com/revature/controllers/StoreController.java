package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.CustomerDAO;
import com.revature.dao.StoreDBDAO;
import com.revature.model.Customer;
import com.revature.model.Product;
import com.revature.model.Store;

public class StoreController extends HttpServlet {
	private static CustomerDAO<Store>store=new StoreDBDAO();
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse response)throws IOException,ServerException
	{
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
			out.print("<a href='Home.html'>Go Back</a>");
		
		List <Store>pro=store.getAllInstance();

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
				

					
					+ "<th>StoreID</th>"
					+ "<th>StoreName</th>"
					+ "<th>City</th>"
					
					+ "<th>State($)</th>"
					);

for (Store customer:pro)
{		 response.getWriter().println("============================ ");
			//resp.getWriter().println(customer.getCustomerID());
		 response.getWriter().println("<tr><td>"+customer.getStoreID()+"</td>");
		 response.getWriter().println("<td>"+customer.getStoreName()+"</td>");		
		 response.getWriter().println("<td>: "+customer.getState()+"</td>");			
			
		 response.getWriter().println("<td>"+customer.getCity()+"</td>");
			
			
		 response.getWriter().println("============================ ");
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
