package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.OrderNew;

public interface OrderService {
	
	OrderNew placeOrder(OrderNew orderNew);
	OrderNew getOrderById(int id);
	OrderNew updateOrder(int id,OrderNew orderNew);
	boolean removeOrder(int id);
	List<OrderNew> orderList();

}
