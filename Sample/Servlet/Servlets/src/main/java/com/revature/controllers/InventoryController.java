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
	throws ServletException ,IOException 
	{	PrintWriter out=response.getWriter();
	out.println("<html><body>");
	
		out.print("<a href='Home.html'>Go Back</a>");
		
	List<	Inventory> in =inventoryDAO.getAllInstance();
	
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
			

				
				+ "<th>InventoryID</td>"
				+ "<th>ProductID</th>"
				
				+ "<th>StoreID</th>"
				+ "<th>Brand</th>"
				+ "<th>Catagory</th>"
				
				+ "<th>Store</th>"
				+ "<th>Location</th>"
				
				+ "<th>Price($)</th>"
				+ "<th>Quantity</th>");
				
		
	

	 for (Inventory customer:in)
	 {
		 response.getWriter().println("============================ ");
			//resp.getWriter().println(customer.getCustomerID());
		 response.getWriter().println("<tr><td>"+customer.getInventoryID()+"</td>");
		 response.getWriter().println("<td> "+customer.getProductID()+"</td>");
		 response.getWriter().println("<td> "+customer.getStoreID()+"</td>");
		 response.getWriter().println("<td> "+customer.getBrand()+"</td>");		
		 response.getWriter().println("<td>  "+customer.getCategory()+"</td>");		
		 response.getWriter().println("<td>: "+customer.getStore()+"</td>");		
		 response.getWriter().println("<td>"+customer.getLocation()+"</td>");		
		 response.getWriter().println("<td>"+customer.getPrice()+"</td>");		
		 response.getWriter().println("<td>"+customer.getQuantity()+"</td></tr><br>");		
			
		 response.getWriter().println("============================ ");
			
	 }
	out.println("</table></center>");
		
		out.println("</body></html>");
		
	
		
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException ,IOException
	{
	
		   String Brand =request.getParameter("Brand");
		  String Store=request.getParameter("Store");
		  String Location=request.getParameter("Location");
		  String Category=request.getParameter("Category");
		 String p= request.getParameter("Price");
		 double Price=Integer.parseInt(p);
		  String Q=request.getParameter("Quantity");
		  int Quantity =Integer.parseInt(Q);
		 int InventoryID=3;
		 int ProductID=4;
		 int StoreID=3;
	Inventory 	inventory =new Inventory(InventoryID, ProductID, StoreID, Brand, Category, Store, Location, Price, Quantity);
		  inventoryDAO.addInstance(inventory);
	  
		  response.sendRedirect("Home.html");
			
		
		
	}
	
	}
	


