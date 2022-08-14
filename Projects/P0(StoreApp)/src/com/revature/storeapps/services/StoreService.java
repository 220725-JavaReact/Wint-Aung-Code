package com.revature.storeapps.services;

import java.util.List;

import com.revature.storeapp.dl.StoreDAO;
import com.revature.storeapp.exception.InvalidStoreException;
import com.revature.storeapp.models.Store;

public class StoreService {
	private final StoreDAO storeDAO;
	
	public StoreService (StoreDAO storeDAO)
	{
		this.storeDAO=storeDAO;
	}
	
	public void register(Store store)
	{
		storeDAO.save(store);
	}
	
	public void delete(String storeID)
	{
		storeDAO.delete(storeID);
	}
	public List<Store>getAllStores()
	{
		return storeDAO.GetEverything();
	}
	public boolean IsNotDuplicatedLocation(String Location)
	{
		List<String> location=storeDAO.getAllLocation();
		if(location.contains(location))throw new InvalidStoreException(" We have a Store in the location:(");
		return true;
	}

}
