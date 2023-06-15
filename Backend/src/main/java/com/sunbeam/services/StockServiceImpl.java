package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.StockDao;
import com.sunbeam.entities.Stock;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao dao;

	@Override
	public Stock addStock(Stock stock) {
		return dao.save(stock);
	}

	@Override
	public Stock updateStock(int id, Stock stock) {
		Stock stock1 = findById(id);
		stock1.setStockCount(stock.getStockCount());
		return dao.save(stock1);
	}

	@Override
	public List<Stock> getAllStocks() {
		return dao.findAll();
	}

	@Override
	public boolean deleteStock(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Stock findById(int id) {
		return dao.getById(id);
	}

}
