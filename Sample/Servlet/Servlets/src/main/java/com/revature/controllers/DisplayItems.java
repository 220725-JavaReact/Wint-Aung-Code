package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.ConnectionFactory;

public class DisplayItems extends HttpServlet{
	
	
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
		
		try	 (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Select * from Inventory";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
			try {
				c=new Cookie(request.getParameter("Inventory"), "1");
				c.setMaxAge(0);
				response.addCookie(c);
				out.print("Product added to your cart");
			}
			catch(Exception e)
			{
				
			}
			out.print("<a href='ViewCartItems'>View Cart</a>");
			out.print(
					"<style> td,th{padding:14px 30px}body{font-faimily:arial;}table{border:1px solid black ;padding:20px;margin-top:-50px:}"
					+ "a{text-decoration:none;border:1px solid black;padding :10px 10px;}a:hover{color:red;}"
					+ "</style>"
							
					+"<table><center><tr><th>ProductID</th><th>Name</th>"
					+ "<th>Category</th>"
					+ "<th>Store</th>"
					+ "<th>Location</th><th>Price</th></tr></table>");
			while(rs.next())
			{
				out.print("<tr><td>"+rs.getInt(1)+"</td>"
			+"<td>"+rs.getString(2)+"</td>"
			+"<td>"+rs.getInt(3)+"</td>"
			+"<td><a href=DisplayItems?InventoryID=" +rs.getInt(1)+"'>Add To Cart</a> </td>"
			+"</tr><br><br>");
				out.print("</center></table></body></html>");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//throw new RuntimeException("An error occured when creat an order into the database ");
		}
		
		
	}
	

	
}
