package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDBDAO;
import com.revature.dao.InventoryDBDAO;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.dao.UserLoginController;
import com.revature.model.Customer;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.model.OrderHistory;


public class InventoryController extends HttpServlet {
	private static ProductDAO<Inventory> inventoryDAO= new InventoryDBDAO() ;
	private static CustomerDAO<Customer> customerDAO= new CustomerDBDAO() ;
	private static ProductDAO<Order> orderDAO= new OrderDBDAO() ;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException ,IOException {

		}
		
	
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException ,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Name=request.getParameter("UserName");
		out.print("welcom"+Name);
		List<Inventory> inventorylist=inventoryDAO.getAllInstance();
		
		out.println("<html><body>");
		out.println("<div>");
		out.println("Plase choose the product item below:");
		out.println("<Style> table,th,td {text-align:center;border:1px solid black; border-collapse: collapse;padding:15 px;border-spaceing :30px;background-color:#D6EEEE;}"
					+ "th:nth-child(even),td:nth-chiled(even){background-color:white;}body{background-color:#1F618D;}head{background-color:red;}input{color:red;background-color:skyblue;}"
					+ "div{background-color: white;}</style>");

		
		
			out.println(
					
					 "<table style= width:100%>");
			out.println("<tr>");
			out.println("<th>ProductID</th>");
			out.println("<th>InventoryID</th>");
			
			out.println("<th>ProductName</th>");
			out.println("<th>Category</th>");
			out.println("<th>Store</th>");
			out.println("<th>StoreID</th>");
			out.println("<th>Location</th>");
			out.println("<th>Price</th>");
			out.println("<th>Quantity</th>");
			out.println("</tr>");	
			out.println("<tr>");	
		
		for(Inventory inventory : inventorylist)
		
		{
			   response.setContentType("text/html");
			
				
					
					
									
					out.println("<td>"+inventory.getProductID()+"</td>");
					out.println("<td>"+inventory.getInventoryID()+"</td>");
					out.println("<td>"+inventory.getBrand()+"</td>");
					out.println("<td>"+inventory.getCategory()+"</td>");
					out.println("<td>"+inventory.getStore()+"</td>");
					out.println("<td>"+inventory.getStoreID()+"</td>");
					out.println("<td>"+inventory.getLocation()+"</td>");
					out.println("<th>"+inventory.getPrice()+"</th>");
					out.println("<th>"+inventory.getQuantity()+"</th>");
					out.println("</tr></table></div>");
					
				
				
		}
		
		out.print("End of table  ");
	
		out.println("</body></html>");
		
				response.getWriter().write("The customer the line number down :" );
				
			
				  
			
		
		
	
	}
	
	}
	


