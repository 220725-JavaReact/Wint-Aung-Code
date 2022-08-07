package com.revature.storeapp.dl;

import com.revature.storeapp.Storage.CustomerStorage;
//import com.revature.storeapp.Storage.ProductList;
import com.revature.storeapp.Storage.ProductStorage;
import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Product;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

public class ProductDAO implements PDAO<Product> {
	private static Logger logger=Logger.getLogger();

	@Override
	public void addInstance(Product newInstance) {
		// TODO Auto-generated method stub
		ProductStorage.productList.add(newInstance);
		logger.log(LogLevel.info,"Adding a new customer "+newInstance.getBrand());
	}

	@Override
	public Product getByName(String Brand) {
		// TODO Auto-generated method stub
		for (Product customer:getAll())
		{
			if(customer.getBrand().equals(Brand)) {
				logger.log(LogLevel.info,"Product" +Brand+ "Found!");
			}
			return customer;
		}
		logger.log(LogLevel.warning,"Product" +Brand+"Not Found!");
		return null;
	}

	@Override
	public Product[] getAll() {
		// TODO Auto-generated method stub
		logger.log(LogLevel.info,"Getting all products"
				);
		return ProductStorage.productList.getAllElements();
		
	}

	@Override
	public void UpdateInstance(Product updatedInstance) {
		// TODO Auto-generated method stub
	
		Product[] allProduct=getAll();

		for(int i=0;i< allProduct.length;i++)
		{
			if(allProduct[i].getBrand().equals(updatedInstance.getBrand()));
			allProduct[i]=updatedInstance;
			break;
		}
	}
  
	
	
}
