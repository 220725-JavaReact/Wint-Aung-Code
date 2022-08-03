package com.revature.bookstore.ui;

import java.util.Scanner;

import com.revature.bookstore.models.Book;
import com.revature.bookstore.exceptions.*;

public class Menu {
	public static void Open() 
	{
		Scanner scanner=new Scanner(System.in);
		String userInput="";
		do 
		{
			System.out.println("Welcome to the New York Store"); 
			System.out.println("Please choose the option to proceed ");
			System.out.println("[1] - Create Customer");
			System.out.println("[2] - Place Order");
			System.out.println("[x] - Exit ");
			
			userInput=scanner.nextLine();
			switch(userInput)
			{
			case "1":
				
				System.out.println("----------------------------------------------------------");
				System.out.println("Please enter your BookName");
				String userName=scanner.nextLine();
				System.out.println("Please enter Author");
				String email=scanner.nextLine();
				
				System.out.println("Please enter   Category");
				String orderlist =scanner.nextLine();
				System.out.println("Please enter price");
				
				
				System.out.println("----------------------------------------------------------");
				Book book=new Book();
				System.out.println(book);
			
				
			break;
			case "2":

				
				System.out.println("----------------------------------------------------------");
				System.out.println("Please login first  !!!");
				System.out.println("Please enter your user name");
				String oldusername=scanner.nextLine();
				System.out.println("Please enter your password");
				String oldpassword=scanner.nextLine();
				
				
				
				
				
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
