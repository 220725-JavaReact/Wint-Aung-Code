package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Cart;
import com.revature.model.Order;

public class AddtToCart extends HttpServlet{
	
	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out=response.getWriter())
		{
			ArrayList<Cart>cartlist=new ArrayList<>();
			int IventoryID=Integer.parseInt(request.getParameter("InventoryID"));
			Cart cart=new Cart();
			cart.setInventoryID(IventoryID);
			cart.setQuantity(1);
			
			
			
			
			HttpSession session=request.getSession();
			ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
			if(cart_list == null)
			{
				cartlist.add(cart);
				session.setAttribute("car-list", cartlist);
				out.println("Session created and added the list");
			}
			
		}
	}

}
