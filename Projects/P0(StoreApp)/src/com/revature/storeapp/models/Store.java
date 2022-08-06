package com.revature.storeapp.models;

public class Store {
	private int StoreID;
	private String storeName ;
	private String location;
	private String description;
	
	public Store(String storeName)
	{
	 this.storeName=storeName;
	 this.location =location;
	 this.description=description;
	}
	
	public Store(String storeName,String location,String description)
	{
	 this.storeName=storeName;
	 this.location=location;
	 this.description=description;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
		return "Store [StoreID=" + StoreID + ", storeName=" + storeName + ", location=" + location + ", description="
				+ description + "]";
	}
	

}
