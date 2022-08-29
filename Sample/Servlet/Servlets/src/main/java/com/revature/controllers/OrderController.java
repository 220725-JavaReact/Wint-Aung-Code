package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

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
import com.revature.dao.ProductDAO;
import com.revature.dao.ProductDBDAO;
import com.revature.model.Customer;
import com.revature.model.Order;
import com.revature.model.Product;

public class OrderController extends HttpServlet {

	private static CustomerDAO<Customer> customerDAO= new CustomerDBDAO() ;
	private static ProductDAO<Product> productDAO= new ProductDBDAO() ;
	private static CustomerDAO<Order> orderDAO =new OrderDBDAO();
	
	
	
	int addcartproduct=0;
	Cookie c=null;
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

			out.println("<tr> <th>ProductID</th><th>InventoryID</th><th>StoreID</th>"
					+ "<th>Store</th><th>Amount</th><th>Category</th><th>Location</th><th>Brand</th><th>Quantity</th><th>UserName</th>");
			
			out.println("<tr>");
			out.println("<th> "+ order.getProductID() +"</th></br>");
			out.println("<th>  "+ order.getInventoryID() +"</th></br>");
			out.println("<th>  "+ order.getStoreID() +"</th></br>");
			out.println("<th>  "+ order.getStore() +"</th></br>");
			out.println("<th>"+ order.getAmount() +"</th></br>");
			out.println("<th> "+ order.getCategory() +"</th></br>");
			
			out.println("<th>Location: "+ order.getLocation()+"</th></br>");
			out.println("<th> Brand: "+ order.getBrand() +"</th></br>");
			out.println("<th> Quantity: "+ order.getQuantity() +"</th></br>");
			out.println("<th> UserName: "+ order.getUserName() +"</th></br></tr>");
			out.println("<table>");
			
		}
		else
		{
			out.println("<i> No custommer in session</i>");
		}
		out.println("</body></html>");
	}
 @Override
 protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException
	{
	 int InventoryID=Integer.valueOf(request.getParameter("InventoryID"));
	 
	 String UserName=request.getParameter("UserName");
	 String Store=request.getParameter("Store");
	 int ProductID=Integer.valueOf( request.getParameter("ProductID"));
	 int StoreID=Integer.valueOf( request.getParameter("StoreID"));
	 
	 String Location=request.getParameter("Location");
	 String ProductName=request.getParameter("ProductName");
	 String Category=request.getParameter("Category");
	 int Price=Integer.valueOf( request.getParameter("Price"));
	 int Quantity=Integer.valueOf( request.getParameter("Quantity"));
	 int TotalAmount =Integer.valueOf(request.getParameter("TotalAmount"));
	 Order order=new Order();
	 order.setProductID(ProductID);
	 order.setsBrand(ProductName);
	 order.setAmount(Quantity);
	 order.setCategory(Category);
	 order.setInventoryID(InventoryID);
	 order.setLocation(Location);
	 order.setStore(Store);
	 order.setStoreID(StoreID);
	 order.setUserName(UserName);
	 order.setAmount(TotalAmount);
	
	 orderDAO.addInstance(order);
	 response.sendRedirect("Cart.html");
	 
	}
 
	
}
