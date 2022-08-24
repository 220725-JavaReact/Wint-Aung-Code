package com.revature.model;

public class Store {
	private int StoreID;
	private String StoreName;
	private String City;
	private String State;
	
	public Store()
	{
		super();
	}
	public Store(String StoreName,String City, String State)
	{
		this.StoreName=StoreName;
		this.City=City;
		this.State=State;
	}
	public int getStoreID() {
		return StoreID;
	}
	public void setStoreID(int storeID) {
		StoreID = storeID;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	@Override
	public String toString() {
		return "Store [StoreID=" + StoreID + ", StoreName=" + StoreName + ", City=" + City + ", State=" + State + "]";
	}
	
	

}
