package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeUserController extends HttpServlet{
	@Override
	public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException
	{
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		
		String Name= req.getParameter("UserName");
		out.print("Welcome"+Name);
		out.close();
		
		
	}
	

}
