package com.revature.storeapps;

import com.revature.storeapp.UI.Menu;
import com.revature.storeapp.UI.PlaceOrderMenu;
import com.revature.storeapp.UI.ShoppingMenu;
import com.revature.storeapp.UI.ShoppingPage;
import com.revature.storeapp.UI.StartMenu;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapps.services.CustomerService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Star program?
Menu.Open();
		
		//Customer 
	// ShoppingMenu.Start(); 
		
		//ADMIN 
//PlaceOrderMenu.PlaceOrderMenu(); 
		
//ShoppingPage .Shoping();  
		//new StartMenu(new CustomerService(new CustomerDBDAO())).Start();
	}
 
}
