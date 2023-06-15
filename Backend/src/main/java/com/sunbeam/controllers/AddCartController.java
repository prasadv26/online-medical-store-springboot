package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.common.CustomResponse;
import com.sunbeam.entities.AddCart;
import com.sunbeam.services.AddCartService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cart")
@RestController
public class AddCartController {

	@Autowired
	private AddCartService service;

	@Autowired
	private CustomResponse response;

	@PostMapping("/addCart")
	public CustomResponse addCart(@RequestBody AddCart cart) {
		AddCart cart1 = null;
		try {
			cart1 = service.saveCart(cart);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if (cart1 != null) {
			response.setStatus("success");
			response.setData(cart1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getCart/{id}")
	public CustomResponse getCart(@PathVariable("id") int id) {
		AddCart cart1 = null;
		try {
			cart1 = service.getCart(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (cart1 != null) {
			response.setStatus("success");
			response.setData(cart1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getCart")
	public CustomResponse getCart() {
		List<AddCart> cart = null;
		try {
			cart = service.getAllCart();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (cart != null) {
			response.setStatus("success");
			response.setData(cart);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@PostMapping("/updateCart")
	public CustomResponse placeOrder(@RequestBody AddCart cart1, int id) {
		AddCart cart = null;
		try {
			cart = service.updateCart(id, cart1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (cart != null) {
			response.setStatus("success");
			response.setData(cart);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@DeleteMapping("/removeCart/{id}")
	public CustomResponse removeOrder(@PathVariable("id") int id) {
		boolean status = false;
		try {
			status = service.deleteCart(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (status == true) {
			response.setStatus("success");
			response.setData("Order deleted Successfully!!!!");
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}
}
