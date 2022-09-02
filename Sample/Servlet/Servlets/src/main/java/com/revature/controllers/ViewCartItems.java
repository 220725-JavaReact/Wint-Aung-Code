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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.InlineView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.CartService;
import com.revature.dao.InventoryDBDAO;
import com.revature.dao.LoginDBDAO;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.dao.UserLoginController;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.util.ConnectionFactory;

public class ViewCartItems extends HttpServlet{
	private static final long serialVersionUID= 1L;
	private static ProductDAO<Inventory>inventoryDAo=new InventoryDBDAO();
	private static CartService carserv=new CartService(new InventoryDBDAO());
	private static ObjectMapper objmap=new ObjectMapper();
	private static ProductDAO<Order>orderDAO=new OrderDBDAO();
	public ViewCartItems()
	{
		super();
	}
	
	Cookie c=null;
	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//
		Connection con=ConnectionFactory.getInstance().getConnection();
		String query;
		PreparedStatement pst;
		ResultSet rs;
		try
		{
			Cookie c=new Cookie(request.getParameter("ItemId"),"1");
			c.setMaxAge(0);//
			response.addCookie(c);
			
			out.print("Product removed from your cart .....");
		}
		catch(Exception e) {}
		out.print("<a href='DisplayItems'>Go Back</a>");
		try 
		{
			Cookie c[]=request.getCookies();//
			out.print("<style>"//
					+ "td,th{padding:14px 30px;}"
					+ "body{font-family:arial;}"
					+ "table{border:1px solid black; padding:20px;margin-top:50px;}"
					+ "a{text-decoration:none;border:1px solid black;padding:10px 10px;}"
					+ "a:hover{color:red;}"
					+ "</style>"
					+ "<table>"
					+ "<tr>"
					+ "<th>InventoryID</tdh>"
					+ "<th>ProductID</th>"
					+ "<th>StoreID</th>"
					+ "<th>Brand</th>"
					+ "<th>Catagory</th>"
					+ "<th>Store</th>"
					+ "<th>Location</th>"
					+ "<th>Price</th>"
					+ "<th>Quantity</th>"
					
					);
//
			for(int i=0;i<c.length;i++)
			{
			query="Select * from Inventory " + c[i].getName()+" ";
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next())
			{
			out.print("<tr><td>"+rs.getInt(1)+"</td>");
				out.print("<td>"+rs.getInt(2)+"</td>");
				out.print("<td>"+rs.getInt(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("<td>"+rs.getString(5)+"</td>");
				out.print("<td>"+rs.getString(6)+"</td>");
				out.print("<td>"+rs.getString(7)+"</td>");
				out.print("<td>"+rs.getInt(8)+"</td>");
				out.print("<td>"+rs.getInt(9)+"</td>");
				out.print("<td><a href='ViewCartItems?ItemId= " + rs.getInt(1)+ "'>Remove From Cart</a></td>"
						+ "</tr><br><br>");
			}
		}
			out.print("</table></body></html");
		
		}
			catch(Exception ex) {}
	
	}
}
