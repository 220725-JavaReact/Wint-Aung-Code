package com.revature.storeapp.models;

public class Inventory {

	private int StoreID;
	private int ProductID;
	private int Quantity;
	public Inventory()
	{
		super();
	}public Inventory(int StoreID,int ProductID,int Quantity)
	{
		this.StoreID=StoreID;
		this.ProductID=ProductID;
		this.Quantity=Quantity;
		
	}
	public int getStoreID() {
		return StoreID;
	}
	public void setStoreID(int storeID) {
		StoreID = storeID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Inventory [StoreID=" + StoreID + ", ProductID=" + ProductID + ", Quantity=" + Quantity + "]";
	}
	
	
	
}
