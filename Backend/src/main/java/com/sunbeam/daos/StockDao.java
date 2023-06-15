package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Stock;

public interface StockDao extends JpaRepository<Stock, Integer> {

	
	
}
