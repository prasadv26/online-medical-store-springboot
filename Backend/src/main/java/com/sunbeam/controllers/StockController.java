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
import com.sunbeam.entities.Stock;
import com.sunbeam.services.StockService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/stock")
@RestController
public class StockController {

	@Autowired
	private CustomResponse response;

	@Autowired
	private StockService service;

	@PostMapping("/addStock")
	public CustomResponse addStock(@RequestBody Stock stock) {

		Stock stock1 = null;

		try {
			stock1 = service.addStock(stock);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (stock1 != null) {
			response.setStatus("success");
			response.setData(stock1);
		} else {
			response.setStatus("error");
			response.setData(" ");
		}

		return response;
	}

	@GetMapping("/getStock/{id}")
	public CustomResponse getStock(@PathVariable("id") int id) {
		Stock stock1 = null;
		try {
			stock1 = service.findById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (stock1 != null) {
			response.setStatus("success");
			response.setData(stock1);
		} else {
			response.setStatus("error");
			response.setData(" ");
		}
		return response;
	}

	@GetMapping("/getAllStock")
	public CustomResponse getAllStock() {
		List<Stock> stock = null;
		try {
			stock = service.getAllStocks();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (stock != null) {
			response.setStatus("success");
			response.setData(stock);
		} else {
			response.setStatus("error");
			response.setData(" ");
		}
		return response;
	}

	@DeleteMapping("/deleteStock/{id}")
	public CustomResponse deleteStock(@PathVariable int id) {
		boolean status = false;
		try {
			status = service.deleteStock(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (status == true) {
			response.setStatus("success");
			response.setData("Stock deleted successfully!!!!!");
		} else {
			response.setStatus("error");
			response.setData(" ");
		}
		return response;
	}

}
