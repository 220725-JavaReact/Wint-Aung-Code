package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.InventoryDBDAO;
import com.revature.dao.InventoryService;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class ViewCartItems extends HttpServlet
{
	private static final long serialVersionUID= 1L;
	private static InventoryService pokeserv=new InventoryService(new InventoryDBDAO());

	private static ProductDAO<Order>orderDAO=new OrderDBDAO();
	public ViewCartItems()
	{
		super();
	}
	
	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
			ServletContext sc=getServletContext();
			String Name= (String) sc.getAttribute("UserName");
			//String name=(String) sc.getAttribute("UserName");		
				
			Logger.getLogger().log(LogLevel.info,"get the attribute of username and cart  ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
		try
		{
			
			
			Cookie c=new Cookie(request.getParameter("ItemId"),"1");
			c.setMaxAge(0);//
			response.addCookie(c);
			Logger.getLogger().log(LogLevel.info,"get the ItemId parameter to put the cookies");
			Logger.getLogger().log(LogLevel.info,"======================================");
			out.print("<h1>WelcomeName "+Name+"</h1>");
			}
		
		catch(Exception e) 
		{
			
		}
		
		Logger.getLogger().log(LogLevel.info,"welcome custoemr with name ");
		Logger.getLogger().log(LogLevel.info,"======================================");
		
		Logger.getLogger().log(LogLevel.info,"show the linke to go back to the display page ");
		Logger.getLogger().log(LogLevel.info,"======================================");
		out.print("<a href='DisplayItems'>Go Back</a>");
		
		out.print("<a href='CartController'>Your Cart</a><br>");
		try {
				
			
	
			Logger.getLogger().log(LogLevel.info,"get the product list from cookies of the inventory list ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
		
			out.print("<style>"//
					+ "td,th{padding:14px 20px;}"
					+ "body{font-family:arial;}"
					+ "table{border:1px solid black; padding:20px;margin-top:50px;}"
					+ "a{text-decoration:none;border:1px solid black;padding:10px 10px;}"
					+ "a:hover{color:red;}"
					+ "</style>"
					+ "<table>"
					+ "<tr>"
					+ "<th>InventoryID</th>"
					+ "<th>ProductID</th>"
					+ "<th>StoreID</th>"
					+ "<th>Brand</th>"
					+ "<th>Catagory</th>"
					+ "<th>Store</th>"
					+ "<th>Location</th>"
					+ "<th>Price</th>"
					
					);
			
			int InventoryID=Integer.valueOf(request.getParameter("ItemId"));
			Logger.getLogger().log(LogLevel.info,"get the inventoryid from ItemId parameter ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
			Inventory id=pokeserv.getInventoryById(InventoryID);
			Logger.getLogger().log(LogLevel.info,"validate the inventory id is it match or not and get the info under the specific id ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
		//	for(int i=0;i<ck.length;i++)
	//{
			
			
			out.print("<tr>"
					+"<td>"+id.getInventoryID()+"</td>"
					+"<td>"+id.getStoreID()+"</td>"
					+"<td>"+id.getProductID()+"</td>"
					+"<td>"+id.getBrand()+"</td>"
					+"<td>"+id.getLocation()+"</td>"
					+"<td>"+id.getStore()+"</td>"
					+"<td>"+id.getCategory()+"</td>"
					+"<td> $"+id.getPrice()+"</td></tr><br>"
					
	
					);
			out.print("<h1><a href='DisplayItems?"+ Name + ">Continue Shoppeing</a></td><h1></tr><br><br>");
			
			Logger.getLogger().log(LogLevel.info,"show the product list from inventory under specific id ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
	//}
			HttpSession session=request.getSession();
			session.setAttribute("cart",Name);
			Logger.getLogger().log(LogLevel.info,"set the attribute to get user name  ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
//			out.print("<p>"+Name+"</p>");
//			CartStorage.cartedlist.add(id);
			Logger.getLogger().log(LogLevel.info,"add the product into temporaray storage  ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
			
			
			int orderid =0;
			int quantity=1;
			Order order1=new Order(id.getPrice(),id.getBrand(),id.getCategory(),Name,id.getStoreID(),id.getStore(),id.getLocation(), id.getProductID(),quantity,id.getInventoryID(),orderid);
			orderDAO.addInstance(order1);
			Logger.getLogger().log(LogLevel.info,"add the product into the cart (order)table ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
	
			
		   
			
			
			out.print("</table></body></html");
			ServletContext scp=request.getServletContext();
			scp.setAttribute("UserName", Name);
			Logger.getLogger().log(LogLevel.info,"carry the attribute of the Name ");
			Logger.getLogger().log(LogLevel.info,"======================================");
			
			
	
	
	}
		catch(Exception e)
		{}
	
	}
	
	}	



		