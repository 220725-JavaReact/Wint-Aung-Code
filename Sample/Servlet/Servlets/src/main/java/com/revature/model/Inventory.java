package com.revature.model;

import com.revature.tests.InvalidPointException;

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
		
		
		public Inventory(String Brand)
		{
			this.Brand=Brand;
			Price=0;
		}
		public Inventory(String Brand,double initialPrice)
		{
			this.Brand=Brand;
			Price= initialPrice;
		}
		
		public Inventory()
		{
			this("wint",1.1);
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
		
		public double addPrice(PriceCategories category)
		{
			this.Price+=category.value;
			return this.Price;
			
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
		
		public double addPrice(double Price)
		{
			if(Price==0)throw new InvalidPointException("You can't add anything");
			this.Price+=Price;
			return this.Price;
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
		
		public enum PriceCategories
		{
			Debug_trainer(1.1),Answer_Question(2.2),Fininsh_activity(3.3),Debug_Assoc(4.4),Laughs_atTrrnerjobk(5.5),Laughattrainer(Double.MIN_VALUE);
			public final double value;
			private PriceCategories(double value)
			{
				
				this.value=value;
			}
			
		}
		

			
}


