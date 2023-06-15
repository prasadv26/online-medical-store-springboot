package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.common.CustomResponse;
import com.sunbeam.entities.OrderDetails;
import com.sunbeam.services.OrderDetailsService;

@RequestMapping("/orderDetails")
@RestController
public class OrderInformationController {

	@Autowired
	private CustomResponse response;

	@Autowired
	private OrderDetailsService service;

	@PostMapping("/saveOrderDetails")
	public CustomResponse saveOrderDetails(@RequestBody OrderDetails detail) {
		OrderDetails details = null;
		try {
			details = service.saveOrderDetails(detail);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (details != null) {
			response.setStatus("success");
			response.setData(details);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getOrderDetail/{id}")
	public CustomResponse getOrderDetail(@PathVariable("id") int id) {
		OrderDetails details = null;
		try {
			details = service.getOrderDetails(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (details != null) {
			response.setStatus("success");
			response.setData(details);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@DeleteMapping("/deleteOrderDetails/{id}")
	public CustomResponse deleteOrderDetails(@PathVariable("id") int id) {
		boolean status = false;

		try {
			status = service.deleteOrderDetails(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (status == true) {
			response.setStatus("success");
			response.setData("OrderDetail deleted Successfully!!!!");
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

}
