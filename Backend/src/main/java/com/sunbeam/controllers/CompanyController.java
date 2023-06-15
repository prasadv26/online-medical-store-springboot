package com.sunbeam.controllers;

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
import com.sunbeam.entities.Company;
import com.sunbeam.services.CompanyService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/company")
@RestController
public class CompanyController {

	@Autowired
	private CompanyService service;

	@Autowired
	private CustomResponse response;

	@PostMapping("/addCompany")
	public CustomResponse addCompany(@ModelAttribute @RequestBody Company company) {
		Company company1 = null;
		try {
			company1 = service.addCompany(company);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (company1 != null) {
			response.setStatus("success");
			response.setData(company1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getCompany/{id}")
	public CustomResponse getCompany(@PathVariable("id") int id) {
		Company company = null;
		try {
			company = service.findById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (company != null) {
			response.setStatus("success");
			response.setData(company);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getCompanyByName/{name}")
	public CustomResponse getCompanyByName(@PathVariable("name") String name) {
		Company company = null;
		try {
			company = service.findByCompanyName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (company != null) {
			response.setStatus("success");
			response.setData(company);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getAllCompany")
	public CustomResponse getAllCompany() {
		List<Company> company = null;
		try {
			company = service.getAllCompany();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (company != null) {
			response.setStatus("success");
			response.setData(company);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}
	
	@PutMapping("/updateCompany/{companyId}")
	   public CustomResponse updateCompany(@PathVariable("companyId") int companyId, 
	           @RequestParam String contact ) {
		System.out.println(contact);
	       try {
	            service.updateCompany(companyId, contact);
	       } catch (Exception e) {
	           System.out.println(e.getMessage());;
	       }
	       response.setStatus("success");
	       response.setData("data updated succesfully");
	       return response;
	   }

	@DeleteMapping("/deleteCompany/{id}")
	public CustomResponse deleteCompany(@PathVariable("id") int id) {
		Boolean status = false;
		try {
			status = service.deleteCompany(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (status == true) {
			response.setStatus("success");
			response.setData("Record Deleted");
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

}
