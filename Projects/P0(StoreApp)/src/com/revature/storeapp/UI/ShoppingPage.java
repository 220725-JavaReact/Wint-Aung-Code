package com.revature.storeapp.UI;

import java.util.List;
import java.util.Scanner;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.InventoryDAO;
import com.revature.storeapp.dl.PDAO;
import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.dl.ProductDBDAO;
import com.revature.storeapp.dl.StoreDAO;
import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.Orders;
import com.revature.storeapp.models.OrdersHistory;
import com.revature.storeapp.models.Product;
import com.revature.storeapp.models.Store;
import com.revature.storeapps.services.CustomerService;
import com.revature.storeapps.services.InventoryService;
import com.revature.storeapps.services.OrderHistoryService;
import com.revature.storeapps.services.OrderService;
import com.revature.storeapps.services.ProductService;
import com.revature.storeapps.services.StoreService;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.annotations.Inject;

public class ShoppingPage {

	private static DAO<Customer>customerDAO2 = new CustomerDBDAO();
	private static DAO<Customer>customerDAO=new CustomerDAO();
	private static DAO<Customer>customerDao2=new CustomerDBDAO();
	private static PDAO<Product>productDAO2=new ProductDAO();
	private static PDAO<Store>storeDAO= new StoreDAO();
	private static PDAO<Inventory>inventoryDAO=new InventoryDAO();
	private static DAO<Product>productDAO=new ProductDBDAO();
	private static Logger logger=Logger.getLogger();
	private static ProductService productService ;
	private static InventoryService inventoryService;
	private static Customer customer ;
	private static StoreService storeService;
	private Orders order;
	private OrdersHistory orderHistory;
	private CustomerService customerService;
	private OrderService orderService;
	
	
	public ShoppingPage(Customer customer2, Orders orders, CustomerDAO customerDAO3, StoreService storeService2,
			ProductService productService2, OrderService orderService2, InventoryService inventoryService2,
			OrderHistoryService orderHistoryService) {
		// TODO Auto-generated constructor stub
	}




//	public  void PlaceOrderMenu(Customer customer,Orders order,OrdersHistory orderHistory, CustomerService customerService, StoreService storeService, ProductService productService, OrderService orderService,InventoryService inventoryService,OrderHistoryService orderhistoryService)
//	{
//		this.customer=customer;
//		this.order=order;
//		this.orderHistory=orderHistory;
//		this.customerService=customerService;
//		this.storeService=storeService;
//		this.productService=productService;
//		this.orderService=orderService;
//		this.inventoryService=inventoryService;
//		this.orderHistory=orderHistory;
//		
//		
//	}
	
	
	
	
	public void Shoping()
	{
	   Scanner scanner= new Scanner (System.in);
	   List<Store>store=storeDAO.GetEverything();
	   String StoreID=null;
	   int storeInput=0;
	   
	   exit:
	   {
		   while(true)
		   {   
			   System.out.println("\n" +drawHorizontalLine("Welcome !", customer.getUserName()));
			   System.out.println("|Welcome"+ customer.getUserName()+ "!|");
			   System.out.println(drawHorizontalLine("Welcome! |", customer.getUserName()));
			   
			   System.out.println(drawSquare("|[1]Products | [2]Order History [3]Profile | [x]Sign out"));
			   
		   }
	   }
	   
	}
	private static String drawHorizontalLine(String msg,String nameLength)
	{
		int len=msg.length()+nameLength.length();
		StringBuilder sb=new StringBuilder();
		
		for (int i=0;i<len;i++)
		{
			if(i==0 || i == len -1)sb.append("+");
			else sb.append("-");
		}
		return sb.toString();
	}
	
	private static String drawSquare(String msg)
	{
		int len =msg.length();
		StringBuilder sb=new StringBuilder();
		for (int i=0 ; i<len; i++)
		{
			sb.append("-");
		}
		return sb.toString();
	}
}
