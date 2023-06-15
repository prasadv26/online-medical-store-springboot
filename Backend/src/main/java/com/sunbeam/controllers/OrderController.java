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

import com.sunbeam.entities.OrderNew;
import com.sunbeam.services.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/order")
@RestController
public class OrderController {

	@Autowired
	private CustomResponse response;

	@Autowired
	private OrderService service;

	@PostMapping("/placeOrder")
	public CustomResponse placeOrder(@RequestBody OrderNew orderNew) {
		OrderNew order1 = null;
		try {
			order1 = service.placeOrder(orderNew);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (order1 != null) {
			response.setStatus("success");
			response.setData(order1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getOrder/{id}")
	public CustomResponse getOrder(@PathVariable("id") int id) {
		OrderNew order1 = null;
		try {
			order1 = service.getOrderById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (order1 != null) {
			response.setStatus("success");
			response.setData(order1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getAllOrders")
	public CustomResponse getAllOrders() {
		List<OrderNew> orderNew = null;
		try {
			orderNew = service.orderList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (orderNew != null) {
			response.setStatus("success");
			response.setData(orderNew);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@DeleteMapping("/removeOrder/{id}")
	public CustomResponse removeOrder(@PathVariable("id") int id) {
		boolean status = false;
		try {
			status = service.removeOrder(id);
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
