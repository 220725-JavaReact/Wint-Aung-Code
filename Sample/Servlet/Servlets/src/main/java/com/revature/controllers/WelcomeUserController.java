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
import com.revature.dao.OrderHistoryDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.dao.UserLoginController;
import com.revature.model.Customer;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.model.OrderHistory;

public class WelcomeUserController extends HttpServlet{
	private static ProductDAO<Inventory> inventoryDAO= new InventoryDBDAO() ;
	private static CustomerDAO<Customer> customerDAO= new CustomerDBDAO() ;
	private static ProductDAO<Order> orderDAO= new OrderDBDAO() ;
	
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException
	{
		
		
		HttpSession session=request.getSession();
		
		Order order=(Order)session.getAttribute("the-order");
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		if(order!=null)
		{
			
			out.println(order.getOrderID());
			out.println(order.getInventoryID());
			out.println(order.getUserName());
			out.println(order.getOrderID());
			out.println(order.getOrderID());
			out.println(order.getOrderID());
			out.println(order.getOrderID());
		}
		
		
	}
	
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException
	{
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
	
		String Name= request.getParameter("customer");
		
		out.print("<h1>Welcome :"+Name+"</h1>");
		 List<Inventory> inventorylist=inventoryDAO.getAllInstance();
			
			int index= 0;
			for(Inventory inventory : inventorylist)
				
			{
				   // response.setContentType("text/html");
				
					out.println("<html><body>");
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
						out.println("<th>Buy</th>");
						out.println("<th><input type = \"submit\" value = \"Product\"/></th>");
						out.println("</tr>");	
						out.println("<tr>");
						
						
						
						
						out.println("<td>"+inventory.getProductID()+"</td>");
						out.println("<td>"+inventory.getInventoryID()+"</td>");
						out.println("<td>"+inventory.getBrand()+"</td>");
						out.println("<td>"+inventory.getCategory()+"</td>");
						out.println("<td>"+inventory.getStore()+"</td>");
						out.println("<td>"+inventory.getStoreID()+"</td>");
						out.println("<td>"+inventory.getLocation()+"</td>");
						out.println("<th>"+inventory.getPrice()+"</th>");
						out.println("<th>"+inventory.getQuantity()+"</th>");
						out.println("<a href=\"/Servlets/ViewCartItems?ItemId="+inventory.getInventoryID()+"\" class= \"btn btn-dark\">Add to Cart</a>");
						out.println("</tr>");
					
						out.print("</table></form></div>");
						out.print("</form> ");
						 
						
						  
				
//						 
//						response.getWriter().write("The customer  :" +UserName +"Customername:"+Login );
					 
//						
						
//				
					out.println("</body></html>");
					
		
		
		out.close();
	}
			Inventory inventory1=new Inventory();
			int InventoryID=inventory1.getInventoryID();
			  int ProductID=inventory1.getProductID();
			  int StoreID=inventory1.getStoreID();
			  String Store=inventory1.getStore();
			  String Location=inventory1.getLocation();
			  String Category=inventory1.getCategory();
			  String Brand=inventory1.getBrand();
			  double Price=inventory1.getPrice();
			  int Quantity=inventory1.getQuantity();
			 HttpSession session=request.getSession();  
			 // session.setAttribute("the-order",order);
			
		
			//  Order order= new Order(Price,Brand,Category,Name,StoreID,Store,Location,ProductID,Quantity,InventoryID);
			//	 orderDAO.addInstance(order);
				
			
	}

}
