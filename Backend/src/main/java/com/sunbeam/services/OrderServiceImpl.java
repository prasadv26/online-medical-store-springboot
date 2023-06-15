package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.OrderDao;
import com.sunbeam.entities.OrderNew;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;

	@Override
	public OrderNew placeOrder(OrderNew orderNew) {
		return dao.save(orderNew);
	}

	@Override
	public OrderNew getOrderById(int id) {
		return dao.getById(id);
	}

	@Override
	public OrderNew updateOrder(int id, OrderNew orderNew) {
		OrderNew order1 = getOrderById(id);
		order1.setOrderDate(orderNew.getOrderDate());
		order1.setTotalCost(orderNew.getTotalCost());
		return order1;
	}

	@Override
	public boolean removeOrder(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<OrderNew> orderList() {
		return dao.findAll();
	}

}
