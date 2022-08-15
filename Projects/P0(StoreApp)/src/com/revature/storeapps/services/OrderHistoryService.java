package com.revature.storeapps.services;

import java.util.List;

import com.revature.storeapp.dl.OrderHistoryDAO;
import com.revature.storeapp.models.OrdersHistory;

public class OrderHistoryService {
	private final OrderHistoryDAO orderhistoryDAO;
	public OrderHistoryService (OrderHistoryDAO orderHistoryDAO)
	{
		this.orderhistoryDAO=orderHistoryDAO;
	}
	public void register(OrdersHistory orderhistory)
	{
		orderhistoryDAO.save(orderhistory);
		
	}
	public List<OrderHistoryService> getOrdersHistories()
	
	{
		
	return orderhistoryDAO.GetEverything();	
	}

}
