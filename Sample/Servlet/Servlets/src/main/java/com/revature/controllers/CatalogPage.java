package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Inventory;
import com.revature.storage.CartStorage;

public class CatalogPage {
	private Inventory[] inventory;
	private String[]itemIDS;
	private String title;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
			{
		

		HttpSession session=request.getSession();
		 
	    	String Name =(String) session.getAttribute("the-customer");
			String name=(String)session.getAttribute("the-cart");
			
		
			//int id=Integer.parseInt(request.getParameter("the-cart"));/////from viewcart items page
			
			
	    // HttpSession session=request.getSession();
			
		PrintWriter out = response.getWriter();
		//response.setContentType("application/json");
	Cookie ck[]=request.getCookies();
	
		Integer InventoryID= 0;
		int ProductID = 0;
		int StoreID=0;
		String Brand=null; String Category=null;String Store=null;String Location=null;
		int Price=0;
		int Quantity=0;
		try 
		{
			
			out.println("<h3>welcome your cart: "+Name );
			if(Name==null)
			{
				out.println("<h3>welcome your cart: "+name );
				
			}
					
			
			
		}
			
			
				
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
				
			 		
//			
		
		//String jsonString=objmap.writeValueAsString(foundinv);
		//response.getWriter().println(jsonString);
;
		response.setContentType("text/html");
			
		
	
out.print("Product removed from your cart successfully..");
		
		out.print("<a href='DisplayItems'>Go Back</a>");
		
		out.print("<style>"//
				+ "td,th{padding:14px 20px;}"
				+ "body{font-family:arial;}"
				+ "table{border:1px solid black; padding:20px;margin-top:50px;}"
				+ "a{text-decoration:none;border:1px solid black;padding:10px 10px;}"
				+ "a:hover{color:red;}"
				+ "</style>"
				+ "<table>"
				+ "<tr>"
				+ "<th>InventoryID</td>"
				+ "<th>ProductID</th>"
				+ "<th>StoreID</th>"
				+ "<th>Brand</th>"
				+ "<th>Catagory</th>"
				+ "<th>Store</th>"
				+ "<th>Location</th>"
				+ "<th>Price</th>"
				+ "<th>Quantity</th>"
				
				);
		

	
				
				
				
//				String js=objmap.writeValueAsString(id);
//				response.getWriter().println(js);
		Inventory[]	ids =CartStorage.cartedlist.getAllElements();
		for(int i=0;i>ids.length;i++)
		{
			
		 	out.print("<tr>"
					+"<td>"+name+"</td>"
					+"<td><input type= \"text\" name =\"Quantity\" placeholder=\"Quantity\"></td>"
					
					
		
					
					
//					+"<td>"+foundinv.getStoreID()+"</td>"
//					+"<td>"+foundinv.getInventoryID()+"</td>"
//					+"<td>"+foundinv.getInventoryID()+"</td>"	
//					+"<td>"+foundinv.getInventoryID()+"</td>"
//					
//					+"<td>"+foundinv.getInventoryID()+"</td>"
//					+"<td>"+foundinv.getInventoryID()+"</td>"
					);
		
		out.print("<td><a href='DisplayItems?ItemId="+name+ "'>Remove from Cart</a></td>"
				+ "</tr><br><br>");
		}	
		out.print("</table></body></html>");
	
				
	

		
		
		
		
			}

}
