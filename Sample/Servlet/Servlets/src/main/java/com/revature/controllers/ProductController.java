package com.revature.controllers;

import java.io.IOException;
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
	{

		ProductDBDAO productDAO=new ProductDBDAO();
		request.setAttribute("products", productDAO.getAll());
		request.getRequestDispatcher("product/index.jsp").forward(request, response);
		
		
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
