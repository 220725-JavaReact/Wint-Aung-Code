package com.revature.storeapp.models;

public class Store {
	private String StoreID;
	private String StoreName ;
	private String location;
	private String description;
	
	public Store()
	{
		super();
	}

	public Store(String StoreName)
	{this .StoreID=StoreID;
	 this.StoreName=StoreName;
	 this.location =location;
	 this.description=description;
	}
	
	public Store(String i,String storeName,String location,String description)
	{
	this.StoreID=i;
	 this.StoreName=storeName;
	 this.location=location;
	 this.description=description;
	}
	

	

	public String getStoreID() {
		return StoreID;
	}

	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
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

	@Override
	public String toString() {
		return "Store [StoreID=" + StoreID + ", storeName=" + StoreName + ", location=" + location + ", description="
				+ description + "]";
	}
	

}
