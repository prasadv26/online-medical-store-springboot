package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	Category findByCategory(String name);
}
