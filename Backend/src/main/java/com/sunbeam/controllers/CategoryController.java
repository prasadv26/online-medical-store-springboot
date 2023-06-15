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
import com.sunbeam.entities.Category;
import com.sunbeam.services.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/category")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;

	@Autowired
	private CustomResponse response;

	@PostMapping("/addCategory")
	public CustomResponse addCategory(@ModelAttribute @RequestBody Category category) {
		Category category1 = null;
		try {
			category1 = service.addCategory(category);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (category1 != null) {
			response.setStatus("success");
			response.setData(category1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getCategory")
	public CustomResponse getCategory(@RequestParam int id) {
		Category category = null;
		try {
			category = service.getById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (category != null) {
			response.setStatus("success");
			response.setData(category);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getAllCategory")
	public CustomResponse getAllCategory() {
		List<Category> category = null;
		try {
			category = service.getAllCategory();
			System.out.println(category.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (category != null) {
			response.setStatus("success");
			response.setData(category);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@GetMapping("/getCategoryByName/{name}")
	public CustomResponse getCategoryByName(@PathVariable("name") String name) {
		Category category = null;
		try {
			category = service.findByCategoryName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (category != null) {
			response.setStatus("success");
			response.setData(category);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}
	
	@PutMapping("/updateCategory/{id}")
	public CustomResponse updateDesc(@PathVariable("id") int id, @ModelAttribute @RequestBody Category category) {
		Category category1 = null;
		try {
			category1 = service.updateDesc(id, category);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (category1 != null) {
			response.setStatus("success");
			response.setData(category1);
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

	@DeleteMapping("/deleteCategory/{id}")
	public CustomResponse deleteCategory(@PathVariable("id") int id) {
		Boolean status = false;
		try {
			status = service.deleteCategory(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (status != true) {
			response.setStatus("success");
			response.setData("Record Deleted!!!");
		} else {
			response.setStatus("error");
			response.setData("");
		}
		return response;
	}

}
