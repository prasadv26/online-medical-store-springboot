package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Stock;

public interface StockService {

	Stock addStock(Stock stock);

	Stock findById(int id);

	Stock updateStock(int id, Stock stock);

	List<Stock> getAllStocks();

	boolean deleteStock(int id);

}
