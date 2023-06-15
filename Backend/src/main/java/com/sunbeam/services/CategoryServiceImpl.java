package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.CategoryDao;
import com.sunbeam.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Override
	public Category addCategory(Category c) {
		return dao.save(c);
	}

	@Override
	public Boolean deleteCategory(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Category findByCategoryName(String name) {
		return dao.findByCategory(name);
	}

	@Override
	public List<Category> getAllCategory() {
		return dao.findAll();
	}

	@Override
	public Category getById(int id) {
		return dao.getById(id);
	}

	@Override
	public Category updateDesc(int categoryId, Category c) {
		Category cat = dao.getById(categoryId);;
		cat.setCategoryDesc(c.getCategoryDesc());
		return dao.save(cat);
	}

}
