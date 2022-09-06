package com.revature.model;

public class Purchase {
	int PurchaseID;
	int OrderHistoryID;
	int InventoryID;
	int ProductID;
	int StoreID;
	String Brand;
	String Category;
	String Store;
	String Location;
	double Amount;
	int Quantity;
	String OrderDate;
	String UserName;
	public Purchase () {
		super();
	}
	
	public Purchase(int OrderHistoryID, int InventoryID, int ProductID, int StoreID, String Brand, String Category, String Store, String Location, double Amount, int Quantity, String OrderDate, String UserName)
	{this.PurchaseID=PurchaseID;
	this.OrderHistoryID=OrderHistoryID;
	this.OrderDate=OrderDate;
	this.ProductID=ProductID;
	this.Brand=Brand;
	this.Category=Category;
	this.Amount=Amount;
	this.Quantity=Quantity;
	this.UserName=UserName;		
	this.Store=Store;
	this.Location=Location;
	this.StoreID=StoreID;
	this.InventoryID=InventoryID;
	
	}
	
		
	

	public int getPurchaseID() {
		return PurchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		PurchaseID = purchaseID;
	}

	public int getOrderHistoryID() {
		return OrderHistoryID;
	}

	public void setOrderHistoryID(int orderHistoryID) {
		OrderHistoryID = orderHistoryID;
	}

	public int getInventoryID() {
		return InventoryID;
	}

	public void setInventoryID(int inventoryID) {
		InventoryID = inventoryID;
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

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
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

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	@Override
	public String toString() {
		return "Purchase [PurchaseID=" + PurchaseID + ", OrderHistoryID=" + OrderHistoryID + ", InventoryID="
				+ InventoryID + ", ProductID=" + ProductID + ", StoreID=" + StoreID + ", Brand=" + Brand + ", Category="
				+ Category + ", Store=" + Store + ", Location=" + Location + ", Amount=" + Amount + ", Quantity="
				+ Quantity + ", OrderDate=" + OrderDate + ", UserName=" + UserName + "]";
	}
	
	
	
}
