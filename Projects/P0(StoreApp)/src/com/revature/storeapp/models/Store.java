package com.revature.storeapp.models;

public class Store {
	private int StoreID;
	private String StoreName ;
	private String location;
	private String description;
	
	public Store(String StoreName)
	{this .StoreID=StoreID;
	 this.StoreName=StoreName;
	 this.location =location;
	 this.description=description;
	}
	
	public Store(int StoreID,String storeName,String location,String description)
	{
	this.StoreID=StoreID;
	 this.StoreName=storeName;
	 this.location=location;
	 this.description=description;
	}


	public String getStoreName() {
		return StoreName;
	}


	public void setStoreName(String StoreName) {
		this.StoreName = StoreName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	


	public int getStoreID() {
		return StoreID;
	}


	public void setStoreID(int storeID) {
		StoreID = storeID;
	}


	@Override
	public String toString() {
		return "Store [StoreID=" + StoreID + ", storeName=" + StoreName + ", location=" + location + ", description="
				+ description + "]";
	}
	

}
