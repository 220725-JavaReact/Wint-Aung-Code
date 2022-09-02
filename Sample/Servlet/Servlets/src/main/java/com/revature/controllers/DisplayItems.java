package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.LoginDBDAO;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.util.ConnectionFactory;

public class DisplayItems extends HttpServlet{
	
	private static ProductDAO<Order>orderDAO=new OrderDBDAO();
	private static final long SerialVerionVID=1L;
	
	public  DisplayItems() {
		// TODO Auto-generated constructor stub
		super();
	}
	int add_cart_product =0;
	Cookie c=null;
	
	protected void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	String Name= request.getParameter("UserName");
		
	//	out.print("<h1>Welcome :"+Name+"</h1>");
		try	 
		{   
			Connection connection =ConnectionFactory.getInstance().getConnection();
			String query="Select * from Inventory";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
			try 
			{
				
				
				c=new Cookie(request.getParameter("ItemId"),"1");
				//c.setMaxAge(0);
				response.addCookie(c);
				
				out.print("Product added to your cart successfully..");
				
			}
			catch(Exception e)
			{
				//e.printStackTrace();
			}
			
			out.print("<a href='ViewCartItems'>View Cart</a>");
			out.print(
					"<style> td,th{padding:14px 20px}body{font-faimily:arial;}table{border:1px solid black ;padding:20px;margin-top:-50px:}"
					+ "a{text-decoration:none;border:1px solid black;padding :10px 10px;}a:hover{color:red;}"
					+ "</style>"
							
					+"<table><tr><th>InventoryID</th>"
					+ "<th>ProductID</th>"
					+ "<th>StoreID</th>"
					
					+ "<th>Brand</th>"
					+ "<th>Category</th>"
					+ "<th>Store</th>"
					+ "<th>Location</th>"
					
					+ "<th>Quantity</th>"
					+ "<th>Price</th>"
					);
			
			
			while(rs.next())
			{
				//fetch record
			out.print("<tr>"
			+ "<td>"+rs.getInt(1)+"</td>"
			+"<td>"+rs.getInt(2)+"</td>"
			+"<td>"+rs.getInt(3)+"</td>"
			
			+"<td>"+rs.getString(4)+"</td>"
			+"<td>"+rs.getString(5)+"</td>"
			+"<td>"+rs.getString(6)+"</td>"	
			+"<td>"+rs.getString(7)+"</td>"
			
			+"<td>"+rs.getInt(8)+"</td>"
			+"<td>"+rs.getInt(9)+"</td>"
			);
			
			
			out.print(
			"<td><a href='DisplayItems?ItemId="+ rs.getInt(1) + "'>Add To Cart</a></td>"
			
			+"</tr><br><br>");
			
			}
			
		
			
			
			out.print("</table></form></body></html>");
			
		}
		
		
		catch(SQLException e)
		{
			e.printStackTrace();
			//throw new RuntimeException("An error occured when creat an order into the database ");
		}
		
		
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
			{
				
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
			String Name= request.getParameter("UserName");
				
				out.print("<h1>Welcome :"+Name+"</h1>");
				
				Order order=new Order();
				
				
			}
	
}
