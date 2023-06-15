package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MedicineDao;
import com.sunbeam.entities.Medicine;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDao dao;

	@Override
	public Medicine findByMedicineId(int id) {
		return dao.getById(id);
	}

	@Override
	public Medicine findByMedicineName(String name) {
		return dao.findByMedicineName(name);
	}

	@Override
	public Medicine addMedicine(Medicine medicine) {
		return dao.save(medicine);
	}

	@Override
	public boolean deleteMedicine(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Medicine> getAllMedicine() {
		return dao.findAll();
	}

	@Override
	public void updateMedicine(int quantity, double price, int id) {
		 dao.updateMedicine(quantity, price, id);
	}

}
