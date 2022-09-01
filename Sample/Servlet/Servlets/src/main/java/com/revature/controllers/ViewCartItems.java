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

public class ViewCartItems extends HttpServlet{

	public ViewCartItems()
	{
		super();
	}
	
	Cookie c=null;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con=ConnectionFactory.getInstance().getConnection();
		String query;
		PreparedStatement pst;
		ResultSet rs;
		try
		{
			Cookie c=new Cookie(request.getParameter("UserName"), "1");
			c.setMaxAge(0);
			response.addCookie(c);
			out.print("Product removed from cart successfully...");
			
		}
		
		catch(Exception e)
		{e.printStackTrace();}
		out.print("<a href='DisplayItems'>Go Back</a>");
		try {
			Cookie ck[]=request.getCookies();
			out.print("<style>td,th{padding:14px 30px;}body{font-family:arial;}"
					+ "table{border:1px solid black;padding:20px;margin-top:50px;}"
					+ "a{text-decoration:none;border:1px solid black;padding:10px 10px;}a:hover{color:red;}</style>"
					+ "<table><tr>"
					+ "<th>ID</th><th>ProductName </th><th>Price</th>");
			for(int i=0;i <ck.length;i++)
			{
				query="Select * from Inventory where InventoryID= "+ck[i].getName()+"";
				pst=con.prepareStatement(query);
				rs=pst.executeQuery();
				while(rs.next())
				{
					out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td>"
							+"<td>"+rs.getInt(3)+"</td>"
							+"<td><a href='ViewCartItems?InventoryID="+ rs.getInt(1)+"'>Remove From Cart</a></td></tr><br><br>");
					
				}
			}
			out.print("</table></body></html>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
