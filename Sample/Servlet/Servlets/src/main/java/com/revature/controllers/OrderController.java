package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDBDAO;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.OrderHistoryDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.dao.ProductDBDAO;
import com.revature.model.Customer;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.model.OrderHistory;
import com.revature.model.Product;

public class OrderController extends HttpServlet {

	private static CustomerDAO<Customer> customerDAO= new CustomerDBDAO() ;
	private static ProductDAO<Product> productDAO= new ProductDBDAO() ;
	private static ProductDAO<Order> orderDAO =new OrderDBDAO();
	//private static ProductDAO<OrderHistory>orderHistoryDAO= new OrderHistoryDBDAO() ;
	

	
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException
	{
	   HttpSession session=request.getSession();
		// 2. get customer from that session.
		
	 //3.after got the customer print out info
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		List<Order>or=orderDAO.getAllInstance();
		out.println("<center><h1>Your Shopping Cart<h1>");
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
			//	+ "<th>OrderID</td>"
				
				
				+ "<th>ProductID</th>"
				+ "<th>InventoryID</td>"
				+ "<th>StoreID</th>"
				+ "<th>Store</th>"
				+ "<th>Location</th>"
				
				+ "<th>Brand</th>"
				+ "<th>Catagory</th>"
				+ "<th>Price($)</th>"
				+ "<th>Quantity</th>");
				
		
		for(Order order :or)
		{			
			
			out.println("<tr><td> "+ order.getProductID() +"</td>");
			out.println("<td>  "+ order.getInventoryID() +"</td>");
			out.println("<td>  "+ order.getStoreID() +"</td>");
			out.println("<td>  "+ order.getStore() +"</th>");
			out.println("<td>"+ order.getLocation() +"</th>");
			out.println("<td> "+ order.getBrand() +"</th>");
			
			out.println("<td> "+ order.getCategory()+"</th>");
			out.println("<td>  "+ order.getAmount() +"</th>");
			out.println("<td>  "+ order.getQuantity() +"</th></tr></br>");
			
			 
			 
			 
			
			 
			
		   //response.sendRedirect("index.jsp");
		  
		}
		out.println("</table></center>");
		
		out.println("</body></html>");
		
	}
 @Override
 protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException
	{
	 HttpSession session=request.getSession();
		
		Order order=(Order)session.getAttribute("the-order");
		

		if(order!=null)
		{
		
	 response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		
				 		
					out.println("<head> <link rel=\"stylesheet\" type=\"text/css\" href=\"editor.css\">\r\n"
							+ " \r\n"
							+ "	 <meta charset=\"UTF-8\">\r\n"
							+ "	  <meta name= \"viewport\" content =\"width=device-width,initial-scales=1.0\">\r\n"
							+ " </head>"
							+ "<body>");
					out.println("<div>");
					out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"editor.css\">");
					
					out.println("Plase choose the product item below:");
					
						out.println("<Style> table,th,td {text-align:center;border:1px solid black; border-collapse: collapse;padding:15 px;border-spaceing :30px;background-color:#D6EEEE;}"
								+ "th:nth-child(even),td:nth-chiled(even){background-color:white;}body{background-color:#1F618D;}head{background-color:red;}input{color:red;background-color:skyblue;}"
								+ "div{background-color: white;}</style></head>");

					
					
						out.println(
								 "<form method=\"get\" action = \"/Servlets/order\">"
								+ "<table style= width:100%>");
						
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
						out.println("<th><input type = \"submit\" value = \"Product\"/></th>");
						out.println("</tr>");	
						out.println("<tr>");
						
						out.println("<td>"+order.getProductID()+"</td>");
						out.println("<td>"+order.getInventoryID()+"</td>");
						out.println("<td>"+order.getBrand()+"</td>");
						out.println("<td>"+order.getCategory()+"</td>");
						out.println("<td>"+order.getStore()+"</td>");
						out.println("<td>"+order.getStoreID()+"</td>");
						out.println("<td>"+order.getLocation()+"</td>");
						out.println("<th>"+order.getAmount()+"</th>");
						out.println("<th>"+order.getQuantity()+"</th>");
						out.println("<a href=\"add-to-cart\" class= \"btn btn-dark\">Add to Cart</a>");
						out.println("</tr>");
					
						out.print("</table></form></div>");
						  
						  
						  
						  
							  
						
											
						
						
						
						
//				
					out.println("</body></html>");
					 
					 		  
				}
		
		
	
	 
	}
 
	
}
