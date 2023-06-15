package com.sunbeam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunbeam.entities.AddCart;

@Service
public interface AddCartService {

	AddCart saveCart(AddCart add);

	AddCart getCart(int id);

	List<AddCart> getAllCart();

	AddCart updateCart(int id, AddCart cart);

	boolean deleteCart(int id);

}
