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

import com.revature.dao.DAO;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.OrderHistoryDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.dao.PurchaseDBDAO;
import com.revature.model.Order;
import com.revature.model.OrderHistory;
import com.revature.model.Purchase;
import com.revature.util.ConnectionFactory;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class CheckoutContorller extends HttpServlet {
	
	private static ProductDAO<Order>orderDAO=new OrderDBDAO();
	private static ProductDAO<Purchase>purchaseDAO=new PurchaseDBDAO();
	private static DAO<OrderHistory>orderhistoryDAO=new OrderHistoryDBDAO();


	
	protected void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ServletContext sc=getServletContext();
		
	String Name= request.getParameter("UserName");
//	String name=(String) sc.getAttribute("UserName");		
	//out.print("<center>Succesful place order !!!!!!<center>");
	out.print("<a href='index.html'>Log Out</a></head><br>");
	
		try	 
		{   
			//out.print("welcome:"+Name);
			
			
			Connection connection =ConnectionFactory.getInstance().getConnection();
			String query="Select Sum(Price) from Orders";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
				
			try {
				
				Cookie	c=new Cookie(request.getParameter("ItemId"),"1");
						
				response.addCookie(c);
				
				
				}catch(Exception e){}
			
		//	out.print("<a href='ViewCartItems'>View Cart</a>");
			while(rs.next())
			{
			
			out.print(
					"<style> td,th{padding:14px 20px}body{font-faimily:arial;}table{border:1px solid black ;padding:20px;margin-top:-50px:}"
					+ "a{text-decoration:none;border:1px solid black;padding :10px 10px;}a:hover{color:red;}"
					+ "</style>"
							
					+"<center><table"
					+ "><tr>");
				out.print("<th>OrderID</th>"
					+ "<th>Brand</td>"
					
					+ "<th>Category</th>"
					+ "<th>Price</th>"
					+ "<th>Quantity</th>"
					+ "<th>Store</th>"
					);
			
			List<Order>ff=orderDAO.getAllInstance();
			for(Order foundinv:ff)
			{
					
				
				out.print("<tr>"
						+"<td>"+foundinv.getOrderID()+"</td>"
						+"<td>"+foundinv.getBrand()+"</td>"
						+"<td>"+foundinv.getCategory()+"</td>"
						
						+"<td> $"+foundinv.getAmount()+"</td>"
						+"<td>"+foundinv.getStore()+"</td>"
								
						+"<td>"+foundinv.getLocation()+"</td>"
				
			+"<tr><td></td><td></td><td></td><td></td><td>Total Amount</td><td>$"+rs.getDouble(1)+"</td></tr>");
				
			out.print("</table></body></html>");
			List< OrderHistory>ID=orderhistoryDAO.getAllInstance();
			for (OrderHistory oh:ID)
				{
				int OrderHistoryID = oh.getOrderHistoryID();
				java.util.Date date=Calendar.getInstance().getTime();
				DateFormat dateFormat= new SimpleDateFormat("mm-dd-yyyy");
				String strDate=dateFormat.format(date);
				Order or=new Order();
				or.getOrderID();
				OrderHistory orderhistory=new OrderHistory(strDate,Name,rs.getDouble(1));
				orderhistoryDAO.addInstance(orderhistory);
				
			Purchase Ph=new Purchase(OrderHistoryID, foundinv.getInventoryID(), foundinv.getProductID(), foundinv.getStoreID(), foundinv.getBrand(), foundinv.getCategory(), foundinv.getStore(),  foundinv.getLocation(),rs.getDouble(1),1,strDate, Name);
			purchaseDAO.addInstance(Ph);
				}
		}
			}
				
			
			
			
			//}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		sc.setAttribute("UserName", Name);
		
	//	sc.setAttribute("UserName",name );
		
}
	

}
