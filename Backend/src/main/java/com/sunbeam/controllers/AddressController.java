package com.sunbeam.controllers;

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
import com.sunbeam.entities.Address;
import com.sunbeam.services.AddressService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/address")
@RestController
public class AddressController {

	@Autowired
	private CustomResponse response;

	@Autowired
	private AddressService service;

	@PostMapping("/addAddress")
	public CustomResponse addAddress(@RequestBody Address address) {
		Address address1 = null;
		try {
			address1 = service.addAddress(address);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (address1 != null) {
			response.setStatus("success");
			response.setData(address1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getAddress/{id}")
	public CustomResponse getAddress(@PathVariable("id") int id) {
		Address address = null;
		try {
			address = service.getAddress(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (address != null) {
			response.setStatus("success");
			response.setData(address);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@DeleteMapping("/deleteAddress/{id}")
	public CustomResponse deleteAddress(@PathVariable("id") int id) {
		try {
			service.deleteAddress(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		response.setStatus("success");
		response.setData("Deleted Successfully!!!");
		return response;
	}

}
