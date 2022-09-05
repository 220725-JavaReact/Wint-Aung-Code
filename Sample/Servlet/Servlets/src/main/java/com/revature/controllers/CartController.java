package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.InventoryDBDAO;
import com.revature.dao.InventoryService;
import com.revature.dao.LoginDBDAO;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.model.Customer;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.storage.CartStorage;

public class CartController extends HttpServlet{

	
	private static ObjectMapper objmap=new ObjectMapper();
	private static InventoryService pokeserv=new InventoryService(new InventoryDBDAO());
	private static ProductDAO<Inventory>inventoryDAo=new InventoryDBDAO();
	private static ProductDAO<Order>orderDAO=new OrderDBDAO();

	
	protected void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
	{
		
		 
		ServletContext sc=getServletContext();
		String Name= (String) sc.getAttribute("Name");
		String name=(String) sc.getAttribute("the-cart");		
		
		
		//	int id=Integer.parseInt(request.getParameter("the-cart"));/////from viewcart items page
			
			
		PrintWriter out = response.getWriter();
		
		try 
		{
			
			out.println("<h3> Your shopping cart </h3>" );
			
			
			response.setContentType("text/html");
				
			out.print("<a href='DisplayItems'>Go Back</a>");
			out.print("<a href='CartController'>Your cart</a>");
			out.print("<a href='CheckoutContorller'>Check Out</a><br>");
			
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
					+ "<th>Price</th>"
					
					+ "<th>Store</th>"
					+ "<th>Location</th>"
								
					);
			
			List<Order>foundiv=orderDAO.getAllInstance();
			for(Order foundinv:foundiv)
			{
				out.print("<tr>"
						+"<td>"+foundinv.getBrand()+"</td>"
						//+"<td>"+foundinv.getProductID()+"</td>"
						//+"<td>"+foundinv.getBrand()+"</td>"	
						+"<td>"+foundinv.getCategory()+"</td>"
						
						+"<td>"+foundinv.getAmount()+"</td>"
						+"<td>"+foundinv.getStore()+"</td>"
								
						+"<td>"+foundinv.getLocation()+"</td>");
					
				
				
			 	
			 	
			out.print("<td><a href='CartDeleteController?ItemId="+foundinv.getOrderID()+ "'>Remove from Cart</a></td>"
					+ "</tr><br><br>");
			//ServletContext scp=request.getServletContext();
			sc.setAttribute("Name", Name);
			//sc.setAttribute("SUM", sum);
			
			}	
			out.print("</table></center></body></html>");
			
		

			
		}
			
			
				
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
				
			 		
	
				
				
				
//				String js=objmap.writeValueAsString(id);
//				response.getWriter().println(js);
					
	
	}


}