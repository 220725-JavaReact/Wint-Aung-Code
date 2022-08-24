package com.revature.model;

public class Order {
	
	int OrderID;
	int ProductID;
	int StoreID;
	String ProductName;
	String Category;
	String InventoryID;
	String Store;
	String Location;
	int Amount;
	int Quantity;
	String UserName;
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
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getInventoryID() {
		return InventoryID;
	}
	public void setInventoryID(String inventoryID) {
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
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
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
				+ ProductName + ", Category=" + Category + ", InventoryID=" + InventoryID + ", Store=" + Store
				+ ", Location=" + Location + ", Amount=" + Amount + ", Quantity=" + Quantity + ", UserName=" + UserName
				+ "]";
	}
	
	

}
