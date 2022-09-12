package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.revature.dao.ProductDAO;
import com.revature.dao.ProductDBDAO;

import com.revature.model.Product;

public class ProductController extends HttpServlet{
	
	private static ProductDAO<Product> productDAO= new ProductDBDAO() ;
	
	private static final long serialVersionUID=1L;
	
	public ProductController()
	{
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{PrintWriter out=response.getWriter();
	out.println("<html><body>");
	
	 out.print("<a href='Home.html'>Go Back</a>");
	out.print("<style>"//
			+ "td,th{padding:10px 20px;}"
			+ "body{font-family:arial;}"
			+ "table{border:1px solid black;text-align:center; padding:20px;margin-top:50px;background-color:#cce5ff;}"
			+ "a{text-decoration:none;border:1px solid black;padding:10px 10px;}"
			+ "button{  background-color:#3949ab;color:#FFF;padding:12px 12px;border-radius:8px;font-size:1.18em;display:inline-block;}"
			+ "a:hover{color:red;}"
			+ "</style><center>"
			+ "<table style= width:100%>"
			+ "<tr>"
			

				
				+ "<th>ProductID</th>"
				
				+ "<th>Brand</th>"
				+ "<th>Catagory</th>"
				
				
				+ "<th>Price($)</th>"
				+ "<th>Quantity</th>");
				

		
		
		
		
		List <Product>pro=productDAO.getAllInstance();
for (Product customer:pro)
{		 response.getWriter().println("============================ ");
			//resp.getWriter().println(customer.getCustomerID());
		 response.getWriter().println("<tr><td>"+customer.getProductID()+"</td>");
		 response.getWriter().println("<td>"+customer.getProductName()+"</td>");		
		 response.getWriter().println("<td>"+customer.getCategory()+"</td>");
			
		 response.getWriter().println("<td>"+customer.getPrice()+"</td>");	
		 response.getWriter().println("<td>"+customer.getQuantity()+"</td><tr><br>");		
			
		 response.getWriter().println("============================ ");
}
		
		
		
		
		
	}
 @Override
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServerException
	{
	 //unpacking form elements sent via request
	  int ProductID=Integer.valueOf(req.getParameter("ProductID"));
	  String ProductName=req.getParameter("ProductName");
	  String Category=req.getParameter("Category");
	  int Price=Integer.valueOf(req.getParameter("Price"));
	  int Quantity=Integer.valueOf(req.getParameter("Quantity"));
	  
	  Product product= new Product();
	  product.setProductID(ProductID);
	  product.setProductName(ProductName);
	  product.setCategory(Category);
	  product.setPrice(Price);
	  product.setQuantity(Quantity);
	  try {
	  productDAO.addInstance(product);
	  }
	  catch (Exception e)
	  {
		  e.printStackTrace();
	  }
	  res.sendRedirect("");
	  
	  
	  
	  
	  
	 
	  HttpSession session=req.getSession();
	  session.setAttribute("the-customer", ProductID);
	  res.getWriter().write("The customer firstname :" +ProductID+ "lastName:" +ProductName+ "is on the loose...." );
	  
	  
	}

}
