package com.sunbeam.services;

import com.sunbeam.entities.OrderDetails;

public interface OrderDetailsService {

	OrderDetails saveOrderDetails(OrderDetails order);

	OrderDetails getOrderDetails(int id);

	boolean deleteOrderDetails(int id);

}
