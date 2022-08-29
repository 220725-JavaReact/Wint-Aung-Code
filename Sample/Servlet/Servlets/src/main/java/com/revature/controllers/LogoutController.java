package com.revature.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		try(PrintWriter out=response.getWriter())
		{
			if(request.getSession().getAttribute("customer")!=null)
			{
				request.getSession().removeAttribute("customer");
				response.sendRedirect("index.html");
			}
			else {
				response.sendRedirect("index.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
