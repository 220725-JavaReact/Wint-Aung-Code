package com.revature.storeapp.UI;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.PDAO;
import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.dl.ProductDBDAO;
import com.revature.storeapp.exception.InvalidStoreException;
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

public class AdminMenu   {

	private final DAO<Customer>customerDAO2 = new CustomerDBDAO();
	private final DAO<Customer>customerDAO=new CustomerDAO();
	private final DAO<Customer>customerDao2=new CustomerDBDAO();
	private static PDAO<Product>productDAO2=new ProductDAO();
	private static DAO<Product>productDAO=new ProductDBDAO();
	private static Logger logger=Logger.getLogger();
	private static ProductService productService ;
	private static InventoryService inventoryService;
	private static Customer customer ;
	private static CustomerService customerService ;
	private static StoreService storeService;
	
	private final Orders order;
	

	


		public static void Start() {
			// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
	        List<Store> stores = storeService.getAllStores();
	        String storeId = null;
	        int storeInput = 0;
	 
	        exit:
	        {
	            while (true) {
	                System.out.println("\n"+ drawHorizontalLine ("| Welcome! |", customer.getUserName()));
	            
	                System.out.println("| Welcome " + customer.getUserName() + "!|");
	                System.out.println(drawHorizontalLine("| Welcome! |", customer.getUserName()));



	                System.out.println(drawSquare("| [1] Clothes     |     [2]Order History     |     [3]Profile     |     [x] Sign out |"));
	                System.out.println("| [1] Clothes     |     [2]Order History    |      [3]Profile     |     [x] Sign out |");
	                System.out.println(drawSquare("| [1] Clothes     |     [2]Order History     |     [3]Profile     |     [x] Sign out |"));

	                System.out.print("\nEnter: ");

	                switch (scan.nextLine()) {
	                    case "1":
	                        System.out.println("\n+---------------------------------------+");
	                        System.out.println("| Which store would you like to shop at?  |");
	                        System.out.println("+-----------------------------------------+");

	                        do {
	                            for (int i = 0; i < stores.size(); i++) {
	                                System.out.println("[" + (i + 1) + "] " + stores.get(i).getLocation());
	                            }

	                            System.out.println("Enter: ");

	                            while (!scan.hasNextInt()) {
	                                String input = scan.next();
	                                System.out.printf("\"%s\" is not a valid number.%n", input);
	                                System.out.println("Enter: ");
	                            }
	                            storeInput = scan.nextInt() - 1;
	                            scan.nextLine();
	                        } while (storeInput < 0);

	                        while(true)
	                        {
	                            if(storeInput < 0 || storeInput >= stores.size()){
	                                System.out.println("Invalid store selection.");
	                            }
	                            else
	                            {
	                                storeId=stores.get(storeInput).getStoreID();
	                             
	                                break;
	                            }

	                            for (int i = 0; i < stores.size(); i++) {
	                                System.out.println("[" + (i + 1) + "] " + stores.get(i).getLocation());
	                            }

	                            System.out.println("Enter: ");
	                            storeInput = scan.nextInt() - 1;
	                            scan.nextLine();


	                        }
	                        viewClothes(storeId);
	                        break;`
	                    case "2":
	                        viewOrderHistory(customer.getCustomerID());
	                        break;
	                    case "3":
	                        viewProfile();
	                        break;
	                    case "x":
	                        break exit;
	                    default:
	                        System.out.println("\nInvalid input.");
	                        break;
	                }
	            }
	        }
	    }
		  private static String drawHorizontalLine(String msg, String nameLength) 
		    {
		        int len = msg.length() + nameLength.length();
		        StringBuilder sb = new StringBuilder();

		        for (int i = 0; i < len; i++) {
		            if (i == 0 || i == len - 1) sb.append("+");
		            else sb.append("-");
		        }

		        return sb.toString();
		    }

		    private static String drawSquare(String msg) 
		    {
		        int len = msg.length();
		        StringBuilder sb = new StringBuilder();

		        for (int i = 0; i < len; i++) {
		            sb.append("-");
		        }

		        return sb.toString();
		    }

	    private static void viewClothes(String storeId) {
	        Scanner scan = new Scanner(System.in);
	        List<Product> products = productService.getAllProducts();
	        List<Orders>orderlist=new ArrayList<>();
	       
	        List<Inventory> inventoryList = inventoryService.getAllInventory();

	        String itemId;
	        String prodId;
	        String prodName;
	        double prodPrice;
	        int prodQuantity;
	        int inventoryQuantity = 0;
	        int input = 0;
	        int currentInventory;

	        System.out.println("\n+---------------------+");
	        System.out.println("| Select to add to cart |");
	        System.out.println("+-----------------------+");

	        //displays all products
	        exit:
	        {
	            while (true){
	                prodId = products.get(input).getProductID();
	                prodName = products.get(input).getBrand();
	                prodPrice = products.get(input).getPrice();

	                for (int i = 0; i < products.size(); i++) {
	                    System.out.println("[" + (i + 1) + "] " + products.get(i).getBrand() + " $" + products.get(i).getPrice());
	                }

	                System.out.print("\nEnter: ");
	                input = scan.nextInt() - 1;


	                //loop through inventories
	                //if the inventory store id matches store id chosen
	                //and product id matches product chosen
	                //get and store quantity

	                for(Inventory i : inventoryList){
	                    if(i.getStoreID().equals(storeId) && i.getProductID().equals(prodId)){
	                        inventoryQuantity = i.getQuantity();
	                    }
	                }
	                System.out.println("Inventory quantity: " + inventoryQuantity);

	                if (input >= 0 && input < products.size()) {
	                    itemId = UUID.randomUUID().toString();

	                    while (true){
	                        System.out.println("How many? ");
	                        prodQuantity = scan.nextInt();
	                        scan.nextLine();

	                        if(prodQuantity > inventoryQuantity){
	                            System.out.println("Sorry there are only " + inventoryQuantity);
	                            break exit;
	                        }else{
	                            currentInventory = inventoryQuantity - prodQuantity;
	                            break;
	                        }
	                    }

	                    //adds items to cart list
	                    order = new Orders(itemId, prodId, prodName, prodPrice, prodQuantity);
	                    cartList.add(Orders);

	                    System.out.println("Checkout (y/n)");
	                    if(Objects.equals(scan.nextLine(), "y")){
	                        //loop through list of carts and call toString on each index to display chosen items
	                        //registers each item
	                        double sum = 0;
	                        for (Cart item : cartList) {
	                            System.out.println(item.partialToString() + "\n");
	                            sum += item.getProductPrice() * item.getProductQuantity();
	                        }

	                        System.out.println("Total: $" + sum);

	                        System.out.println("Buy (y/n): ");

	                        switch (scan.nextLine()){
	                            case "y":
	                                //add order to history
	                                Date date = Calendar.getInstance().getTime();
	                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                                String strDate = dateFormat.format(date);

	                                history = new History(UUID.randomUUID().toString(), user.getId(), strDate, sum);
	                                historyService.register(history);

	                                //subtract quantity with inventory quantity matching product number
	                                System.out.println(currentInventory);
	                                inventoryService.update(storeId, prodId, currentInventory);
	                                break exit;
	                            case "n":
	                                break;
	                            default:
	                                System.out.println("\nInvalid input.");
	                                break;
	                        }
	                    }
	                }else{
	                    System.out.println("Invalid product selection.");
	                    break;
	                }
	            }
	        }

	    }

	    private static void viewOrderHistory(String userId){
	        //filter through list of order histories to find orders where history user id equals user id
	        //adds to list
	        List<OrdersHistory> allHistory = historyService.getAllHistories();
	        Scanner scan = new Scanner(System.in);

	        System.out.println("\n+-------------+");
	        System.out.println("| Order History |");
	        System.out.println("+---------------+");

	        List<OrdersHistory> userHistory = allHistory.stream().filter(h -> h.getCustomerID().equals(customer.getCustomerID())).collect(Collectors.toList());
	        userHistory.forEach((h -> System.out.println(h.toString() + " " + "\n")));

	        if(userHistory.size() > 0){
	            System.out.println("\n         +------------------------+");
	            System.out.println("Sort by  | earliest to oldest (1) |");
	            System.out.println("         +------------------------+");
	            System.out.println("\n         +------------------------+");
	            System.out.println("         | oldest to earliest (2) |");
	            System.out.println("         +------------------------+");

	            switch (scan.nextLine()){
	                case "1":
	                    List<History> sortByDate = userHistory.stream().sorted(Comparator.comparing(History::getOrderDate)).collect(Collectors.toList());
	                    sortByDate.forEach(d -> System.out.println(d + " " + "\n"));
	                    break;
	                case "2":
	                    List<History> sortByDateReverse = allHistory.stream().sorted(Comparator.comparing(History::getOrderDate).reversed()).collect(Collectors.toList());
	                    sortByDateReverse.forEach(d -> System.out.println(d + " " + "\n"));
	                    break;
	                default:
	                    System.out.println("Invalid input");
	                    break;
	            }

	        }else{
	            System.out.println("You don't have any orders");
	        }


	    }

	    private static void viewProfile(){
	        while(true){
	            Scanner scan = new Scanner(System.in);
	            System.out.println("\n+----------+");
	            System.out.println("| My Profile |");
	            System.out.println("+------------+");

	            System.out.println("Information: ");
	            System.out.println(user.getUsername());

	            int totalPoints = generatePoints();

	            System.out.println("\n-----My Points-----");
	            System.out.println("\n         " + totalPoints);

	            System.out.println("\n----------------------");
	            System.out.println("Press (x) to exit");

	            if(scan.nextLine().equals("x")){
	                break;
	            }else{
	                System.out.println("Invalid input");
	            }
	        }




	    }

	    private int generatePoints(){
	        List<OrdersHistory> allHistory = order.getAllHistories();

	        List<History> userHistory = allHistory.stream().filter(h -> h.getUserId().equals(user.getId())).collect(Collectors.toList());

	        return userHistory.size();

	    }


	  
			
		}
