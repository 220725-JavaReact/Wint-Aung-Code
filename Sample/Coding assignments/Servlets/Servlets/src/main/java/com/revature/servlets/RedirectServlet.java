package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HelloServlet {

	@Override
	protected void doGet(HttpServletRequest rs,HttpServletResponse res) throws IOException, ServletException
	{
		res.sendRedirect("http://www.google.com/teapot");
	}
}
