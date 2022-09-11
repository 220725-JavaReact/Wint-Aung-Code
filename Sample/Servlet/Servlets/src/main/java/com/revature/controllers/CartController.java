package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.OrderDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.model.Order;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class CartController extends HttpServlet{

	public CartController()
	
	{
		super();
	}
	private static ProductDAO<Order>orderDAO=new OrderDBDAO();

	
	protected void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
	{
		HttpSession session=request.getSession();
		String Name =(String) session.getAttribute("username");
			
		
		Logger.getLogger().log(LogLevel.info,"Getting inside of  the shopping cart page");
		Logger.getLogger().log(LogLevel.info,"======================================");
		Logger.getLogger().log(LogLevel.info,"get the cart list  ");
		Logger.getLogger().log(LogLevel.info,"======================================");
		
		
		
		//	int id=Integer.parseInt(request.getParameter("the-cart"));/////from viewcart items page
			
		session.setAttribute("username", Name);
	    
		PrintWriter out = response.getWriter();
		
		try 
		{
			
			out.println("<h3> Your shopping cart </h3>" );
			
			
			response.setContentType("text/html");
			//	out.println("Welcome :"+Name);
				
			out.print("<a href='DisplayItems'>Go Back</a>");
			session.setAttribute("username", Name);
			
			out.print("<a href='CartController'>Your cart</a>");
			session.setAttribute("username", Name);
			
			out.print("<a href='CheckoutContorller'>Check Out</a><br>");
			session.setAttribute("username", Name);
			
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
				//	+ "<th>OrderID</td>"
					
					//+ "<th>InventoryID</td>"
					//+ "<th>ProductID</th>"
					+ "<th>Brand</th>"
				//	+ "<th>StoreID</th>"
					+ "<th>Catagory</th>"
					+ "<th>Price($)</th>"
					
					+ "<th>Store</th>"
					+ "<th>Location</th>"
								
					);
			
			List<Order>foundiv=orderDAO.getAllInstance();
			for(Order foundinv:foundiv)
			{
				Logger.getLogger().log(LogLevel.info,"show the cart list of customer ");
				Logger.getLogger().log(LogLevel.info,"======================================");
				
				out.print("<tr>"
						+"<td>"+foundinv.getBrand()+"</td>"
						//+"<td>"+foundinv.getProductID()+"</td>"
						//+"<td>"+foundinv.getBrand()+"</td>"	
						+"<td>"+foundinv.getCategory()+"</td>"
						
						+"<td> $"+foundinv.getAmount()+"</td>"
						+"<td>"+foundinv.getStore()+"</td>"
								
						+"<td>"+foundinv.getLocation()+"</td>");
					
				
				
			 	
				session.setAttribute("username", Name);
				
			out.print("<td><a href='CartDeleteController?ItemId="+foundinv.getOrderID()+ "'>Remove </a></td>"
					+ "</tr><br><br>");
			session.setAttribute("username", Name);
			Logger.getLogger().log(LogLevel.info,"bring the name to setattibute ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
			
			}	
			out.print("</table></center></body></html>");
			
			session.setAttribute("username", Name);
		    
			
		}
			
			
				
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		session.setAttribute("username", Name);
	    
//				String js=objmap.writeValueAsString(id);
//				response.getWriter().println(js);
					
	
	}


}