package com.revature.servlets;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws IOException, ServerException
		{
 
		res.sendRedirect("/Servlets/Mainmenu");
		}
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
	{
	
		RequestDispatcher redis=req.getRequestDispatcher("/redirect");
		redis.forward(req, resp);
	}

}
