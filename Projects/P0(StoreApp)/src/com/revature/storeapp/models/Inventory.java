package com.revature.storeapp.models;

public class Inventory {

	private String StoreID;
	private String ProductID;
	private int Quantity;
	public Inventory()
	{
		super();
	}public Inventory(String StoreID,String ProductID,int Quantity)
	{
		this.StoreID=StoreID;
		this.ProductID=ProductID;
		this.Quantity=Quantity;
		
	}
	public String getStoreID() {
		return StoreID;
	}
	public void setStoreID(int i) {
		i = i;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
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
	public void setProductId(int productID2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
