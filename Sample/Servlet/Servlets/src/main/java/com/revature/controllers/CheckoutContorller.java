package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.OrderDBDAO;
import com.revature.dao.OrderHistoryDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.model.Order;
import com.revature.model.OrderHistory;
import com.revature.util.ConnectionFactory;

public class CheckoutContorller extends HttpServlet {
	
	private static ProductDAO<Order>orderDAO=new OrderDBDAO();
	private static ProductDAO<OrderHistory>orderhisoryDAO=new OrderHistoryDBDAO();

	
	protected void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		
	String Name= request.getParameter("UserName");
	String name=request.getParameter("the-cart");		
		
		try	 
		{   
			Connection connection =ConnectionFactory.getInstance().getConnection();
			String query="Select Sum(Price) from Orders";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
			if(Name==null)
			{
			out.print("<h1>Welcome :"+name+"</h1>");
			}
			else 
			{
				out.print("<h1>Welcome :"+Name+"</h1>");
					}
				
			try {
				
				Cookie	c=new Cookie(request.getParameter("ItemId"),"1");
						
				response.addCookie(c);
				
				out.print("Product added to your cart successfully..");
				
				}catch(Exception e){}
			
			out.print("<a href='ViewCartItems'>View Cart</a>");
			
			out.print(
					"<style> td,th{padding:14px 20px}body{font-faimily:arial;}table{border:1px solid black ;padding:20px;margin-top:-50px:}"
					+ "a{text-decoration:none;border:1px solid black;padding :10px 10px;}a:hover{color:red;}"
					+ "</style>"
							
					+"<table><tr>"
					//+ "<th>InventoryID</th>"
					//+ "<th>ProductID</th>"
				//	+ "<th>StoreID</th>"
					
					+ "<th>Brand</th>"
					+ "<th>Category</th>"
					+ "<th>Store</th>"
					+ "<th>Location</th>"
					
					+ "<th>Price</th>"
					);
			while(rs.next())
			{
				//fetch record
			out.print("<tr>"
			//+ "<td>"+rs.getInt(1)+"</td>"
			//+"<td>"+rs.getInt(2)+"</td>"
			//+"<td>"+rs.getInt(3)+"</td>"
			
			+"<td>"+rs.getString(4)+"</td>"
			+"<td>"+rs.getString(5)+"</td>"
			+"<td>"+rs.getString(6)+"</td>"	
			+"<td>"+rs.getString(7)+"</td>"
			
			+"<td>"+rs.getInt(9)+"</td>"
			);
				
			
			out.print("<td><a href='ViewCartItems?ItemId="+ rs.getInt(1) + "'>Add To Cart</a></td></tr><br><br>");
			
			
			
			//(double Amount String Brand, String Category,String userName,int StoreID,String Store,String Location,int productID ,int Quantity ,int InventoryID)
//			Order order=new Order(rs.getDouble(8),rs.getString(4),rs.getString(5),Name,rs.getInt(3),rs.getString(6), rs.getString(7), rs.getInt(2), rs.getInt(9),rs.getInt(1));
//			orderDAO.addInstance(order);
			}
			
			 	
			out.print("</table></body></html>");
			
		    }
			
		
		catch(SQLException e)
		{
			e.printStackTrace();
			//throw new RuntimeException("An errorcc  occured when creat an order into the database ");
		}
		ServletContext sc=request.getServletContext();
		sc.setAttribute("UserName", Name);
		
		sc.setAttribute("the-cart",name );
		
}
	

}
