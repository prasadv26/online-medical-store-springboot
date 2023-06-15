package com.sunbeam.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.common.CustomResponse;
import com.sunbeam.dtos.MedicineDto;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.Company;
import com.sunbeam.entities.Medicine;
import com.sunbeam.services.AddressService;
import com.sunbeam.services.CompanyService;
import com.sunbeam.services.MedicineService;

@RequestMapping("/medicine")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MedicineController {

	@Autowired
	private MedicineService service1;

	@Autowired
	private CustomResponse response;

	@PostMapping("/addMedicine")
	public CustomResponse addMedicine(@ModelAttribute @RequestBody Medicine medicine) {

		Medicine m1 = null;

		try {
			m1 = service1.addMedicine(medicine);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (m1 != null) {
			response.setStatus("success");
			response.setData(m1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

//	@PostMapping("/addMedicine")
//	public CustomResponse addMedicine(@RequestBody MedicineDto medicine) {
//
//		Medicine m1, m2 = null;
//		Company c1, c2 = null;
//		Address a1, a2 = null;
//		
//		m1 = new Medicine(medicine.getMedicineId(), medicine.getMedicineName(), medicine.getMedicineDesc(),
//				medicine.getPrice(), medicine.getMfgDate(), medicine.getExpDate(), medicine.getQuantity());
//		
//		c1 = new Company(medicine.getCompanyId(), medicine.getCompanyName(), medicine.getCompanyDesc(),
//				medicine.getContact(), medicine.getLocation());
//		
//		a1 = new Address(medicine.getAddressId(), medicine.getAddressLine(), medicine.getCity(), medicine.getState(),
//				medicine.getCountry(), medicine.getPostalCode());
//		
//		try {
//			m2 = service1.addMedicine(m1);
//			c2 = service2.addCompany(c1);
//			a2 = service3.addAddress(a1);
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		if (m2 != null && c2 != null && a2 != null) {
//			response.setStatus("Success");
//			response.setData(medicine);
//		} else {
//			response.setStatus("error");
//			response.setData("");
//		}
//		return response;
//	}

	@GetMapping("/getAllMedicine")
	public CustomResponse getAllMedicine() {
		List<Medicine> m1 = null;
		try {
			m1 = service1.getAllMedicine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (m1 != null) {
			response.setStatus("success");
			response.setData(m1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}
	
	@GetMapping("/getMedicineById/{id}")
	public CustomResponse getMedicineById(@PathVariable int id) {
		Medicine m1 = null;
		System.out.println(id);
		try {
			m1 = service1.findByMedicineId(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (m1 != null) {
			response.setStatus("success");
			response.setData(m1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;

	/*	Medicine m1 = null;
		MedicineDto newDto = null;
		try {
			m1 = service1.findByMedicineId(id);
			newDto = MedicineDto.fromEntity(m1);
			System.out.println("output"+newDto.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (m1 != null) {
			response.setStatus("success");
			response.setData(newDto);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;*/
	}

	@GetMapping("/getMedicineByName/{name}")
	public CustomResponse getMedicineByName(@PathVariable String name) {
		Medicine m1 = null;
		try {
			m1 = service1.findByMedicineName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (m1 != null) {
			response.setStatus("success");
			response.setData(m1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@PutMapping("/updateMedicine/{id}")
	public CustomResponse updateMedicine(@RequestParam int quantity, @RequestParam double price,
			@PathVariable("id") int id) {
		try {
			service1.updateMedicine(quantity, price, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		response.setStatus("success");
		response.setData("");
		return response;
	}

	@DeleteMapping("/deleteMedicine/{id}")
	public CustomResponse deleteMedicine(@PathVariable int id) {
		boolean status = false;
		try {
			status = service1.deleteMedicine(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (status == true) {
			response.setStatus("success");
			response.setData(status);
		} else {
			response.setStatus("error");
			response.setData(status);
		}
		return response;
	}

}
