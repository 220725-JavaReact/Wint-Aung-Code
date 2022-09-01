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
	private static ProductDAO<OrderHistory>orderHistoryDAO= new OrderHistoryDBDAO() ;
	

	
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException
	{
	   HttpSession session=request.getSession();
		// 2. get customer from that session.
		Order order=(Order)session.getAttribute("the-order");
		
	 //3.after got the customer print out info
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(order!=null)
		{
			out.println("Your Shopping Cart");
			out.println("<table>");
			out.println("<Style> table,th,td {text-align:center;border:1px solid black; border-collapse: collapse;padding:15 px;border-spaceing :30px;background-color:#D6EEEE;}"
					+ "th:nth-child(even),td:nth-chiled(even){background-color:white;}body{background-color:#1F618D;}head{background-color:red;}input{color:red;background-color:skyblue;}"
					+ "div{background-color: white;}</style></head>");
			out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"editor.css\">\r\n"
					+ " ");
			out.println("<tr> <th>ProductID</th><th>InventoryID</th><th>StoreID</th>"
					+ "<th>Store</th><th>Amount</th><th>Category</th><th>Location</th><th>Brand</th><th>Quantity</th><th>UserName</th>");
			
			out.println("<tr>");
			
			
			out.println("<th> "+ order.getProductID() +"</th></br>");
			out.println("<th>  "+ order.getInventoryID() +"</th></br>");
			out.println("<th>  "+ order.getStoreID() +"</th></br>");
			out.println("<th>  "+ order.getStore() +"</th></br>");
			out.println("<th>"+ order.getAmount() +"</th></br>");
			out.println("<th> "+ order.getCategory() +"</th></br>");
			
			out.println("<th> "+ order.getLocation()+"</th></br>");
			out.println("<th>  "+ order.getBrand() +"</th></br>");
			out.println("<th>  "+ order.getQuantity() +"</th></br>");
			out.println("<th>  "+ order.getUserName() +"</th></br></tr>");
			out.println("<table>");
			 out.println("ORderID:"+order.getOrderID());
			
			 
			 
			 
			
			 
			
		   //response.sendRedirect("index.jsp");
		  
		}
		else
		{
			out.println("<i> No custommer in session</i>");
		}
		
		out.println("\r\n"
				+ "<div class=\"container\">\r\n"
				+ "<div class=\"d-flex py-3\"><h3>Total Price:$ 452</h3><a class=\"mx-3 btn btn-primary\" href=\"#\">Check Out </a></h3>\r\n"
				+ "<table class=\"table table-loght\">\r\n"
				+ "<thead>\r\n"
				+ "<tr>\r\n"
				+ "<th scope=\"col\">Name</th>\r\n"
				+ "<th scope=\"col\">Category</th>\r\n"
				+ "<th scope=\"col\">Price</th>\r\n"
				+ "<th scope=\"col\">Quantity</th>\r\n"
				+ "<th scope=\"col\">Store</th>\r\n"
				+ "<th scope=\"col\">Buy Now</th>\r\n"
				+ "<th scope=\"col\">Cancel</th>\r\n"
				+ "</tr></thead>\r\n"
				+ "<tbody>\r\n"
				+ "<tr>\r\n"
				+ "<td>"+order.getBrand()+"</td>\r\n"
				+ "<td>"+order.getCategory()+"</td>\r\n"
				+ "<td>"+order.getAmount()+"</td>\r\n"
				+ "<td>"+order.getQuantity()+"</td>\r\n"
						+ "<td>"+order.getStore()+"</td>\r\n"
				+ "<td>\r\n"
				+ "<form method=\"post\" action = \"\" class=\"form-inline\">\r\n"
				+ " 			<input type = \"hidden\" name =\"id\" value=\"1\" class=\"form-input\"/>\r\n"
				+ " 			<div class=\"from-group d-flex justify-content-between\">\r\n"
				+ " 			<a class=\"btn btn-sm bthn-incre\" href=\"\"><i class=\"fas fa-plus-square\"></i></a> \r\n"
				+ " 			<input type=\"text\" name=\"Quantity\" class=\"form-control\" value=\"1\" readonly>\r\n"
				+ "  			<a class=\"btn btn-sm bthn-incre\" href=\"\"><i class=\"fas fa-minus-square\"></i></a> \r\n"
				+ " 			</div>\r\n"
				+ " 			\r\n"
				+ " 	 	</form>\r\n"
				+ "\r\n"
				+ "</td>\r\n"
				+ "</tr></tbody>\r\n"
				+ "</table>\r\n"
				+ "</div>\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ " 		");
		
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

						 int InventoryID=order.getInventoryID();
						  int ProductID=order.getProductID();
						  int StoreID=order.getStoreID();
						  String Store=order.getStore();
						  String Location=order.getLocation();
						  String Category=order.getCategory();
						  String Brand=order.getBrand();
						  double Price=order.getAmount();
						  int Quantity=order.getQuantity();
						  String Name=order.getUserName();
						  int OrderID=order.getOrderID();
						double TotalAmount=Quantity *Price;
						   java.util.Date date=Calendar.getInstance().getTime();
						   DateFormat dateFormat=new SimpleDateFormat("mm-dd-yyyy");
						   String OrderDate=dateFormat.format(date);
						   OrderHistory orderHistory=new OrderHistory(InventoryID, StoreID, ProductID, OrderDate, Name, TotalAmount);
						   orderHistoryDAO.addInstance(orderHistory);
						  
						  
						  
						  
						  
						  
						  Order order1= new Order(Price,Brand,Category,Name,StoreID,Store,Location,ProductID,Quantity,InventoryID);
						  orderDAO.addInstance(order1);
						  
						  
						 
				
//						 
//						response.getWriter().write("The customer  :" +UserName +"Customername:"+Login );
					 
//						
						  session.setAttribute("the-order",order);
						  
						  
						
											
						
						
						
						
//				
					out.println("</body></html>");
					 
					 		  
				}
		
		
	
	 
	}
 
	
}
