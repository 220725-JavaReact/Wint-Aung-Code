package com.revature.storeapp.Storage;
import java.util.List;

import com.revature.storeapp.dl.ProductDBDAO;
import com.revature.storeapp.models.Product;

public class ProductList {
	

	Product[] backingArray;
	int lastIndex;
	
	public ProductList()
	{
		backingArray=new Product[10];
		lastIndex=0;
	}
	public void add(Product newProduct)
	{
		if(lastIndex==backingArray.length)
		{ // wat if the arraylist has reach ed max cap?
			int newSize=(int)(lastIndex* 1.5);
			Product[]newBacking =new Product[newSize];
			
			//newBacking=backingArray.clone();
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex]=newProduct;
		lastIndex++;
	}
//	public List<Product>ProductList()
//	{
//		List<Product>product= ProductDBDAO.ProductList();
//		return product;
//	}
	
	public Product[]getAllElements()
	{
		
		return backingArray;
	}

}
