package com.revature.model;

public class Order {
	
	int OrderID;
	int ProductID;
	int StoreID;
	String Brand;
	String Category;
	int InventoryID;
	String Store;
	String Location;
	double Amount;
	int Quantity;
	String UserName;
	
	public Order()
	{
		super();
	}
	
	public  Order(double Amount,String Brand, String Category,String userName,int StoreID,String Store,String Location,int productID ,int Quantity ,int InventoryID)
	{
		
		this.ProductID=productID;
		this.Brand=Brand;
		this.Category=Category;
		this.Amount=Amount;
		this.Quantity=Quantity;
		this.UserName=userName;		
		this.Store=Store;
		this.Location=Location;
		this.StoreID=StoreID;
		this.InventoryID=InventoryID;
		
	}
	
	
		public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public int getStoreID() {
		return StoreID;
	}
	public void setStoreID(int storeID) {
		StoreID = storeID;
	}
	public String getBrand() {
		return Brand;
	}
	public void setsBrand(String Brand) {
		Brand = Brand;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getInventoryID() {
		return InventoryID;
	}
	public void setInventoryID(int inventoryID) {
		InventoryID = inventoryID;
	}
	public String getStore() {
		return Store;
	}
	public void setStore(String store) {
		Store = store;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	@Override
	public String toString() {
		return "Order [OrderID=" + OrderID + ", ProductID=" + ProductID + ", StoreID=" + StoreID + ", ProductName="
				+ Brand + ", Category=" + Category + ", InventoryID=" + InventoryID + ", Store=" + Store
				+ ", Location=" + Location + ", Amount=" + Amount + ", Quantity=" + Quantity + ", UserName=" + UserName
				+ "]";
	}
	
	

}
