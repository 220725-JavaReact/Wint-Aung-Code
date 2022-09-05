package com.revature.model;

public class ShoppingCart {

	String Brand;
	int Quantity;
	int amount;
	
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ShoppingCart [Brand=" + Brand + ", Quantity=" + Quantity + ", amount=" + amount + "]";
	}
	
	
}
