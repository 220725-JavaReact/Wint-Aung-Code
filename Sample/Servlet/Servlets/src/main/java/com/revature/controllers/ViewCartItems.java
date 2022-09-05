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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.InventoryDBDAO;
import com.revature.dao.InventoryService;
import com.revature.dao.OrderDBDAO;
import com.revature.dao.OrderHistoryDBDAO;
import com.revature.dao.ProductDAO;
import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.model.OrderHistory;
import com.revature.storage.CartStorage;

public class ViewCartItems extends HttpServlet
{
	private static final long serialVersionUID= 1L;
	private static ObjectMapper objmap=new ObjectMapper();
	private static InventoryService pokeserv=new InventoryService(new InventoryDBDAO());
	private static ProductDAO<Inventory>inventoryDAo=new InventoryDBDAO();
	private static ProductDAO<OrderHistory>orderHistoryDAO=new OrderHistoryDBDAO();

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
			String name=(String) sc.getAttribute("the-cart");		
				
        
		try
		{
			
			
			Cookie c=new Cookie(request.getParameter("ItemId"),"1");
			c.setMaxAge(0);//
			response.addCookie(c);
			
		}
		
		catch(Exception e) 
		{
			
		}
		out.print("WelcomeName "+Name);
		
		out.print("<a href='DisplayItems'>Go Back</a>");
		out.print("<a href='CartController'>Your Cart</a>");
		try {
				
			
	
			Cookie ck[]=request.getCookies();
		
		
			out.print("<style>"//
					+ "td,th{padding:14px 20px;}"
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
					+ "<th>Pricess</th>"
					
					);
			
			int InventoryID=Integer.valueOf(request.getParameter("ItemId"));
			Inventory id=pokeserv.getInventoryById(InventoryID);
			
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
					+"<td>"+id.getPrice()+"</td>"
					
	
					);
			
	//}
			HttpSession session=request.getSession();
			session.setAttribute("cart",id);
//			out.print("<p>"+Name+"</p>");
//			out.print("<p>"+id+"</p>");
			CartStorage cs=new CartStorage();
			CartStorage.cartedlist.add(id);
			
			Inventory []order =CartStorage.cartedlist.getAllElements();
			int orderid =0;
			int quantity=1;
			Order order1=new Order(id.getPrice(),id.getBrand(),id.getCategory(),Name,id.getStoreID(),id.getStore(),id.getLocation(), id.getProductID(),quantity,id.getInventoryID(),orderid);
			orderDAO.addInstance(order1);
	
			
		   
			
			
			out.print("</table></body></html");
			ServletContext scp=request.getServletContext();
			sc.setAttribute("Name", Name);
			
	
	
	}
		catch(Exception e)
		{}
	
	}
	
	}	



		