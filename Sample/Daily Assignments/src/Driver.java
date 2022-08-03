import java.util.Scanner;

import com.revature.restrev.exception.InvalidRatingException;
import com.revature.restrev.models.Restaurant;
import com.revature.restrev.ui.Menu;
import com.revature.restrev.util.Logger;
import com.revature.restrev.util.Logger.LogLevel;

public class Driver {
	private static Logger logger=new Logger();
  
	public static void main(String[] args) 
	{
		Menu menu=new Menu();
		// TODO Auto-generated method stub
//		System.out.println("Hello World");
//		String userInput="";
//		Scanner scanner =new Scanner (System.in);
//		do 
//		{
//			System.out.println("[1]See that welcome message again");
//			System.out.println("[2]Create Restaurant");
//			System.out.println("[x]Exit");
//			userInput = scanner.nextLine();
//			switch(userInput)
//			{
//			case"1":
//				System.out.println("Hello World");
//				break;
//			case "2":
//				Restaurant newRestaurant=new Restaurant();
//				System.out.println("What's the restaurant name?");
//				newRestaurant.name=scanner.nextLine();
//				System.out.println("City?");
//				newRestaurant.city=scanner.nextLine();
//				System.out.println("State");
//				newRestaurant.state=scanner.nextLine();
//				System.out.println("Rating? out of 5");
//
//				try{
//					newRestaurant.setRating(scanner.nextInt());
//					scanner.nextLine();
//				}
//				catch (InvalidRatingException e) 
//				{
//					System.out.println(e.getMessage());
//					//continue;
//				}
//				
//				//newRestaurant.rating=Integer.parseInt(scanner.nextLine());
////				newRestaurant.rating =scanner.nextInt();
////				scanner.nextLine();
//				
//				System.out.println("Describe your dinning experience");
//				newRestaurant.description=scanner.nextLine();
//				System.out.println(newRestaurant);
//				break;
//				
//			case "x":
//				System.out.println("Goodbye cruel world...");
//				break;
//			default:
//				logger.log(LogLevel.warning, "Hey! its invalid input");
//			System.out.println("Wrong input,pls try again  ");
//			
//			}
//		}
//		
//		while(!(userInput.equals("x")));
		
	}

}
