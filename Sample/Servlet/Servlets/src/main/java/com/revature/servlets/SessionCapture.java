package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Customer;

public class SessionCapture extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServerException
	{
		//1. grab the session from the request
		HttpSession session=req.getSession();
		// 2. get customer from that session.
		Customer customer=(Customer)session.getAttribute("the-customer");
	 //3.after got the customer print out info
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		if(customer!=null)
		{
			out.println("We have captured the customer");
			out.println("<h1> Customer firstname: "+ customer.getFirstName() +"</h1></br>");
			out.println("<b> Customer lastname: "+ customer.getLastName() +"</b></br>");
			out.println("<b> Customer username: "+ customer.getUserName() +"</b></br>");
			out.println("<i> Customer password: "+ customer.getPassword() +"php</i></br>");
		}
		else
		{
			out.println("<i> No custommer in session</i>");
		}
		out.println("</body></html>");
	}
	@Override

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServerException
	{
		HttpSession session=req.getSession();
		//clearing the session
		
		session.invalidate();
	}
}
