package com.revature.storeapp.models;

public class Inventory {
    private String InventoryID;
	private String Brand;
	private String Category;
	private String Store;
	private String Location;
	private int Price;
	private int Quantity;
	private String StoreID;
	private String ProductID;
	public Inventory()
	{
		super();
	}
	public Inventory(String InventoryID,String Brand,String Category,String StoreID,String Store,String Location, int Price,int Quantity,String ProductID)
	{	this.Brand=Brand;
	this.Category=Category;
		this.Store=Store;
		this.StoreID=StoreID;
		
		this.Location=Location;
		this.Price=Price;
		this.Quantity=Quantity;
		this.ProductID=ProductID;
		this.StoreID=StoreID;
		this.InventoryID=InventoryID;
		
	}
	public Inventory(int InventoryID,String StoreID,String ProductID,int Quantity)
	{  InventoryID=InventoryID;
		Quantity=Quantity;
		StoreID=StoreID;
		ProductID=ProductID;
		
	}
	
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getStoreID() {
		return StoreID;
	}
	public void setStoreID(String storeID) {
		StoreID = storeID;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getInventoryID() {
		return InventoryID;
	}
	public void setInventoryID(String inventoryID) {
		InventoryID = inventoryID;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
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
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Inventory [InventoryID=" + InventoryID + ", Brand=" + Brand + ", Category=" + Category + ", Store="
				+ Store + ", Location=" + Location + ", Price=" + Price + ", Quantity=" + Quantity + ", StoreID="
				+ StoreID + ", ProductID=" + ProductID + "]";
	}
	
	
}
