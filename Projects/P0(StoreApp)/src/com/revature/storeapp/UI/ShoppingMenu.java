package com.revature.storeapp.UI;

import java.util.Scanner;

import javax.lang.model.element.QualifiedNameable;

import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.OrdersDAO;
import com.revature.storeapp.dl.PDAO;
import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.models.Customer;

import com.revature.storeapp.models.Orders;
import com.revature.storeapp.models.Product;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

public class ShoppingMenu 
{
private static DAO<Orders> orderDAO= new OrdersDAO();
private static PDAO<Product>productDAO=new ProductDAO(); // without array storage
private static Orders orders;
private static Logger logger=Logger.getLogger();
	public static void Start()
	{
		Scanner scanner=new Scanner(System.in);
	
		String userInput="";
		logger.log(LogLevel.info," Member start to shop ");
	
		do 
		{  
			System.out.println("====================================================");
			System.out.println(" ~~~~~~~~~~Welcome to the New York Store!~~~~~~~~~~~");
			System.out.println("====================================================");
		
			System.out.println("Please select form the list of options below:\n");
			System.out.println("================  Customer Menu   ===================");
		
			
			
			System.out.println("[1] - Login");
			System.out.println("[2] - Order History");
			System.out.println("[2] - Exit");
			
			
			System.out.println("====================================================");
		
			userInput =scanner.nextLine().toUpperCase();
			switch(userInput)
			{			
			case"1":
			ShoppingItem();//looping product list 
								
			break;
			case"2":
				try {
				for (Orders order:orderDAO.getAll())
				{
					System.out.println(order);
				}
					System.out.println("Please choose your pick up store location!");
				}
				catch (Exception e)
				{
					System.out.println("Sorry! you have to log in first");
				}
			break;
			case "x":
				System.out.println("Thank for your visit");
				Menu.Open();
				break;
			
			default :
			System.out.println("Oopps!That wasn't a Valid Choice ");
			System.out.println(" Plase try again and choose the valid option");
			break;
			/// first switch close 
			}
			
			}// do close  
		
		while(!(userInput.equals("x")));
		logger.log(LogLevel.info, "Existing App");

		
		
	}
	
	public static void ShoppingItem()
	
	{
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Plase enter your User Name");
		String UserName=scanner.nextLine();
		System.out.println("Plase enter your Password ");
		String Password=scanner.nextLine();
				
		//customerDAO.addInstance(customer);
		System.out.println("====================================================");
		System.out.println("****************Succssfully Login !!!*************\n");
		System.out.println("====================================================");	
		logger.log(LogLevel.info," Member start to shop ");
		
		System.out.println("Do you wanna buy this product? ");
		System.out.println("Please enter yes or no !! ");
		
		for (Product product:productDAO.GetEverything())
		{
		System.out.println("====================================================");
		System.out.println(product);
		System.out.println("ID         -  [" + product.getProductID()+"]");
		System.out.println("Brand      -  ["  +product.getBrand()+"]");
		System.out.println("Category   -  ["+product.getCategory()+"]");
		System.out.println("Price      -  [" +product.getPrice()+"]");
		System.out.println("Quantity   -  [" +product.getQuantity()+"]");
		System.out.println("Store      -  [" +product.getStore()+"]");
		System.out.println("Location   -  [" +product.getStoreLocation()+"]");
		System.out.println("====================================================");
		System.out.println("PRESS YES [OR] NO");
	
		logger.log(LogLevel.info," Member start to shop ");
		String answer =scanner.nextLine();
			switch(answer)
				{
				case "Yes":
				case "yes":
				System.out.println("Please enter the ID of the product what what you like to buy!!!");
				System.out.println("Plase enter ID of your choosen product!! ");
				int ProductID=scanner.nextInt();
				System.out.println("Plase enter ID of your Quantity !! ");
				int Quantity =scanner.nextInt();
				int qty =product.getQuantity();
					while (Quantity > qty)
				{
					System.out.println("Pleas enter valid amount ");
				}
					logger.log(LogLevel.info," Member choose the product ");
				System.out.println("This is the list of product you want to buy !!!!!!!");
				String Brand= product.getBrand();
				int Price = product.getPrice();
				String store =product.getStore();
				String location =product.getStoreLocation();
				int amount = (product.getPrice() * Quantity);
				System.out.println("ProductID   -   [" +ProductID+"]" );
				System.out.println("Brand      -   [" +Brand +"]");
				System.out.println("Quantity    -  [" +Quantity +"]");
				System.out.println("store     -  [" +store +"]");
				System.out.println("location    -   [" +location+"]" );
				System.out.println("Amount    -  [" +amount +"]");
				System.out.println("====================================================");
				
				System.out.println("\n Would you like to checkout ? !");
				System.out.println("\n Press yes  no for exit !");
				
				System.out.println("====================================================");
				
				String ans=scanner.nextLine();
				
				if (ans=="yes" && ans =="Yes")
				{
				Orders order= new Orders(amount, Brand, UserName, store, location, ProductID, Quantity);
				System.out.println(order);
			 orderDAO.save(order);
			 logger.log(LogLevel.info," Member make an order ");
				}
				else
				{
					Menu.Open();
				}
							
				
				
				
				
				break;
				
				case "No":
				case "no":
					
				
				System.out.println("===================Press Down Arrow Key ============================");
//				System.out.println("ID         -  [" + product.getProductID()+"]");
//				System.out.println("Brand      -  ["  +product.getBrand()+"]");
//				System.out.println("Category   -  ["+product.getCategory()+"]");
//				System.out.println("Price      -  [" +product.getPrice()+"]");
//				System.out.println("Quantity   -  [" +product.getQuantity()+"]");
//				System.out.println("Store      -  [" +product.getStore()+"]");
				//System.out.println("Location   -  [" +product.getStoreLocation()+"]");
//				System.out.println("====================================================");
//				System.out.println("========NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN=================================");
			
				break;
				
				default:
				System.out.println("Oopps!That wasn't a Valid Choice ");
				System.out.println(" Plase try again and choose the valid option");
				break;
					
				
			    }
			while(!(answer.equals("no")));
			
				
		}
	}
	

}
