package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AddCartDao;
import com.sunbeam.entities.AddCart;

@Service
public class AddCartServiceImpl implements AddCartService {

	@Autowired
	private AddCartDao dao;

	@Override
	public AddCart saveCart(AddCart add) {
		return dao.save(add);
	}

	@Override
	public AddCart getCart(int id) {
		return dao.getById(id);
	}

	@Override
	public List<AddCart> getAllCart() {
		return dao.findAll();
	}

	@Override
	public AddCart updateCart(int id, AddCart cart) {
		AddCart cart1 = getCart(id);
		cart1.setCreateDate(cart.getCreateDate());
		cart1.setQuantity(cart.getQuantity());
		return dao.save(cart1);
	}

	@Override
	public boolean deleteCart(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}
}
