package com.revature.model;

public class Inventory {

	 private int InventoryID;
		private String Brand;
		private String Category;
		private String Store;
		private String Location;
		private double Price;
		private int Quantity;
		private int StoreID;
		private int ProductID;
		public Inventory()
		{
			super();
		}
		public Inventory(int InventoryID,int ProductID,int StoreID,String Brand,String Category,String Store,String Location,double Price,int Quantity)
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
		
		
		public String getCategory() {
			return Category;
		}
		public void setCategory(String category) {
			Category = category;
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
		
		public int getInventoryID() {
			return InventoryID;
		}
		public void setInventoryID(int inventoryID) {
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
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
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
