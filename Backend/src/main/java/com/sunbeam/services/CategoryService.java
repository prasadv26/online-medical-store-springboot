package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Category;

public interface CategoryService {

	Category addCategory(Category c);

	Boolean deleteCategory(int id);

	Category findByCategoryName(String name);

	List<Category> getAllCategory();

	Category getById(int id);
	
	Category updateDesc (int categoryId, Category c);

}
