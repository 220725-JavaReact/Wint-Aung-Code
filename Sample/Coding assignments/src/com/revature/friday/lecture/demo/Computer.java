package com.revature.friday.lecture.demo;

public class Computer {
	private int price;
	private String brand;
	public int getprice()
	{
		
		return price;
	}
	public void setPrice(int Price)
	{
		if(price >=0)
		{
			this.price=price;
		}
		else
		{
			this.price =0 ;
		}
		
	}
	public String getBrand()
	{
		return brand;
	}
public void setBrand(String brand) {
	this.brand=brand;
}
}
