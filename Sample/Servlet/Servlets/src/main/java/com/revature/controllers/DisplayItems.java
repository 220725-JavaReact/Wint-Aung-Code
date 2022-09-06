package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.model.Order;
import com.revature.util.ConnectionFactory;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class DisplayItems extends HttpServlet{
	
	private static ProductDAO<Order>orderDAO=new OrderDBDAO();
	private static Logger logger=Logger.getLogger();

	private static final long SerialVerionVID=1L;
	
	public  DisplayItems() {
		// TODO Auto-generated constructor stub
		super();
	}
	int add_cart_product =0;
	
	protected void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		ServletContext sc=getServletContext();
		//String name=(String) sc.getAttribute("UserName");		
		
	String Name= request.getParameter("UserName");
	
		
		try	 
		{   
			Connection connection =ConnectionFactory.getInstance().getConnection();
			String query="Select * from Inventory";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
			
			
			Logger.getLogger().log(LogLevel.info,"select * from Inventory table ");
			
			if(Name==null)
			{
			//out.print("<h1>Welcome :"+name+"</h1>");
			Logger.getLogger().log(LogLevel.info,"get the name from userlogin page if not null:name:");
			
			}
			else 
			{
				out.print("<h1>Welcome :"+Name+"</h1>");
				
			}
				
			
			try {
				
				Cookie	c=new Cookie(request.getParameter("ItemId"),"1");
				Logger.getLogger().log(LogLevel.info,"get the parameter from cookie to get stock ");
				Logger.getLogger().log(LogLevel.info,"======================================");
				
						
				response.addCookie(c);
				out.print("Product added to your cart successfully..");
				
				
				}catch(Exception e){}
			
			out.print("<a href='ViewCartItems'>View Cart</a><br>");
			Logger.getLogger().log(LogLevel.info,"User choose to view the cart");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
			
			
			out.print(
					"<style> td,th{padding:14px 20px}body{font-faimily:arial;}table{border:1px solid black ;padding:20px;margin-top:-50px:}"
					+ "a{text-decoration:none;border:1px solid black;padding :10px 10px;}a:hover{color:red;}"
					+ "</style>"
							
					+"<center><table><tr>"
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
			Logger.getLogger().log(LogLevel.info,"show the product list from inventory ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
			out.print("<tr>"
			+"<td>"+rs.getString(4)+"</td>"
			+"<td>"+rs.getString(5)+"</td>"
			+"<td>"+rs.getString(6)+"</td>"	
			+"<td>"+rs.getString(7)+"</td>"
			
			+"<td> $"+rs.getInt(9)+"</td>"
			);
				
			
			out.print("<td><a href='ViewCartItems?ItemId="+ rs.getInt(1) + "'>Add To Cart</a></td></tr><br><br>");
			Logger.getLogger().log(LogLevel.info,"use add the prroduct and show the info of the choosen product ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
			
			
			//(double Amount String Brand, String Category,String userName,int StoreID,String Store,String Location,int productID ,int Quantity ,int InventoryID)
//			Order order=new Order(rs.getDouble(8),rs.getString(4),rs.getString(5),Name,rs.getInt(3),rs.getString(6), rs.getString(7), rs.getInt(2), rs.getInt(9),rs.getInt(1));
//			orderDAO.addInstance(order);
			}
			
			 	
			out.print("</table></center></body></html>");
			
		    }
			
		
		catch(SQLException e)
		{
			e.printStackTrace();
			//throw new RuntimeException("An errorcc  occured when creat an order into the database ");
		}
		sc.setAttribute("UserName", Name);
		Logger.getLogger().log(LogLevel.info,"try to bring the username to ViewCartPage ");
		Logger.getLogger().log(LogLevel.info,"======================================");
		
	//	sc.setAttribute("UserName",name );
		
		}
}
		
//	}
//	protected void service(HttpServletRequest request,HttpServletResponse response)
//			throws ServletException,IOException
//			{
//	
//		
//		
//		
//		
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//	String Name= request.getParameter("the-customer");
//		
//		out.print("<h1>Welcome :"+Name+"</h1>");
//		try	 
//		{   
//			Connection connection =ConnectionFactory.getInstance().getConnection();
//			String query="Select * from Inventory";
//			PreparedStatement preparedStatement=connection.prepareStatement(query);
//			ResultSet rs=preparedStatement.executeQuery();
//			try 
//			{
//				
//				
//				c=new Cookie(request.getParameter("ItemId"),"2");
//				//c.setMaxAge(0);
//				response.addCookie(c);
//				
//				out.print("Product added to your cart successfully..");
//				
//			}
//			catch(Exception e)
//			{
//				//e.printStackTrace();
//			}
//			
//		
//			out.print("<a href='ViewCartItems'>View Cart</a>");
//			
//			out.print(
//					"<style> td,th{padding:14px 20px}body{font-faimily:arial;}table{border:1px solid black ;padding:20px;margin-top:-50px:}"
//					+ "a{text-decoration:none;border:1px solid black;padding :10px 10px;}a:hover{color:red;}"
//					+ "</style>"
//							
//					+"<table><tr><th>InventoryID</th>"
//					+ "<th>ProductID</th>"
//					+ "<th>StoreID</th>"
//					
//					+ "<th>Brand</th>"
//					+ "<th>Category</th>"
//					+ "<th>Store</th>"
//					+ "<th>Location</th>"
//					
//					+ "<th>Quantity</th>"
//					+ "<th>Price</th>"
//					);
//			
//			
//			while(rs.next())
//			{
//				//fetch record
//			out.print("<tr>"
//			+ "<td>"+rs.getInt(1)+"</td>"
//			+"<td>"+rs.getInt(2)+"</td>"
//			+"<td>"+rs.getInt(3)+"</td>"
//			
//			+"<td>"+rs.getString(4)+"</td>"
//			+"<td>"+rs.getString(5)+"</td>"
//			+"<td>"+rs.getString(6)+"</td>"	
//			+"<td>"+rs.getString(7)+"</td>"
//			
//			+"<td>"+rs.getInt(8)+"</td>"
//			+"<td>"+rs.getInt(9)+"</td>"
//			);
//			
//
//
//			out.print("</table></form></body></html>");
//			int InventoryID=rs.getInt(1);
//			int ProductID=rs.getInt(2);
//			int StoreID=rs.getInt(3); 
//			String Brand=rs.getString(4);
//			String Category=rs.getString(5);
//			String Store=rs.getString(6);
//			String Location=rs.getString(7);
//			double Price=rs.getInt(8);
//			int Quantity=rs.getInt(9);
//			Order order= new Order(Price,Brand,Category,Name,StoreID,Store,Location,ProductID,Quantity,InventoryID);
//			orderDAO.addInstance(order);
//			
//			//Inventory ink=new Inventory(InventoryID, ProductID, StoreID, Brand, Category, Store, Location, Price, Quantity);
//		//	CartStorage.cartedlist.add(ink);
//		   out.print(
//			"<td><a href='ViewCartItems?ItemId="+ rs.getInt(1) + "'>Add To Cart</a></td>"
//			 
//			);
//
//			
//			}
//			
//			
//			
//		
//			
//			
//		}
//		
//		
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//			//throw new RuntimeException("An error occured when creat an order into the database ");
//		}
//		
//		
//		
//		
//		
//			}
//	

