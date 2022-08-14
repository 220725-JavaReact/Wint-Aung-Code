package com.revature.storeapp.models;

public class Orders
{
	
	String OrderID;
	int ProductID;
	String Brand;
	int Amount;
	String Store;
	String Location;
int Quantity;
	String userName;
	public Orders()
	{
		super();
	}
	
	public Orders(int Amount,String Brand, String userName,String Store,String Location,int ProductID ,int Quantity )
	{
		//this.OrderID=OrderID;
		this.ProductID=ProductID;
		this.Brand=Brand;
		this.Amount=Amount;
		this.Quantity=Quantity;
		this.userName=userName;		
		this.Store=Store;
		this.Location=Location;
		
		
	}
	
	

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
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

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Orders [OrderID=" + OrderID + ", ProductID=" + ProductID + ",  Brand="
				+ Brand + ", Amount=" + Amount + ", Store=" + Store + ", Location=" + Location + ", Quantity="
				+ Quantity + ", userName=" + userName + "]";
	}

	public String partialToString()
	{
		return "Brand:"+Brand+"\n Price:"+Amount+"\n Quantity:" +Quantity;
	}

	
	
}