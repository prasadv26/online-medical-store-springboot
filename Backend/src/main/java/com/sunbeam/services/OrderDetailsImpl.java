package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.OrderDetailsDao;
import com.sunbeam.entities.OrderDetails;

@Service
public class OrderDetailsImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsDao dao;

	@Override
	public OrderDetails saveOrderDetails(OrderDetails order) {
		return dao.save(order);
	}

	@Override
	public OrderDetails getOrderDetails(int id) {
		return dao.getById(id);
	}

	@Override
	public boolean deleteOrderDetails(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}
}
