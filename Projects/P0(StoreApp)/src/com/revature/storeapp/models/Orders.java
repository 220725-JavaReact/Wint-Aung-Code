package com.revature.storeapp.models;

public class Orders
{
	
	int OrderID;
	int  ProductID;
	int StoreID;
	String Brand;
	String Category;
	int Amount;
	String Store;
	String Location;
	int InventoryID;
int Quantity;
	String userName;
	public Orders()
	{
		super();
	}
	
	public Orders(int Amount,String Brand, String Category,String userName,int StoreID,String Store,String Location,int productID ,int Quantity ,int InventoryID)
	{
		//this.OrderID=OrderID;
		this.ProductID=productID;
		this.Brand=Brand;
		this.Category=Category;
		this.Amount=Amount;
		this.Quantity=Quantity;
		this.userName=userName;		
		this.Store=Store;
		this.Location=Location;
		this.StoreID=StoreID;
		this.InventoryID=InventoryID;
		
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

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
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


	public String partialToString()
	{
		return "Brand:"+Brand+"\n Price:"+Amount+"\n Quantity:" +Quantity;
	}

	@Override
	public String toString() {
		return "Orders [OrderID=" + OrderID + ", ProductID=" + ProductID + ", StoreID=" + StoreID + ", Brand=" + Brand
				+ ", Category=" + Category + ", Amount=" + Amount + ", Store=" + Store + ", Location=" + Location
				+ ", InventoryID=" + InventoryID + ", Quantity=" + Quantity + ", userName=" + userName + "]";
	}

	
	
}