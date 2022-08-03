package com.revature.storeapp.UI;

import java.util.Scanner;

import com.revature.storeapp.models.Customer;

public class ProductMenu {
	
	public void ProductMenu()
	{
		Scanner scanner=new Scanner(System.in);
		String userInput="";
		do 
		{
			System.out.println("Welcome to the New York Store"); 
			System.out.println("Please choose the option to proceed ");
			System.out.println("[1] - Computer-$ 1099");
			System.out.println("[2] - Phone - 999$");
			System.out.println("[x] - Tablet - 899$ ");
			
			userInput=scanner.nextLine();
			switch(userInput)
			{
			case "1":
				
				System.out.println("----------------------------------------------------------");
				System.out.println("You choose to buy a computer !!!");
				System.out.println("Please type the brand name");
				String userName=scanner.nextLine();
				System.out.println("Please enter y");
				String email=scanner.nextLine();
				System.out.println("Please enter your  order list");
				String orderlist =scanner.nextLine();
				System.out.println("Please enter your  phone number");
				String phone =scanner.nextLine();
				System.out.println("----------------------------------------------------------");
				Customer customer=new Customer(userName, email,  phone,orderlist);
				System.out.println(customer);
			
				
			break;
			case "2":

				ProductMenu productmenu=new ProductMenu();
				
			break;
			case "x":
				System.out.println("You choose to exit");
			break;
			default:
				System.out.println("Invalid Input");
			break;
			
			}
			
			
		}
		while (!userInput.equals("x"));
		
	}
}

