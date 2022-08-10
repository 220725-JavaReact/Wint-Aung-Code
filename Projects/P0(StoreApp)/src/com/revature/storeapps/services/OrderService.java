package com.revature.storeapps.services;


import java.util.List;

import com.revature.storeapp.dl.OrdersDAO;
import com.revature.storeapp.models.Orders;

public class OrderService {
	private final OrdersDAO orderDAO;
	
	public OrderService(OrdersDAO orderDAO)
	{
		this.orderDAO=orderDAO;
		
	}
	public void register (Orders order)
	
	{
		orderDAO.save(order);
	}
	public List<Orders>getAllOrderedItems()
	{
		return orderDAO.GetEverything();
	}
	

}
