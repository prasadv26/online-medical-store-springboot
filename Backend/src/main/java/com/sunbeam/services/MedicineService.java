package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Medicine;

public interface MedicineService {
	
	Medicine findByMedicineId(int id);
	Medicine findByMedicineName(String name);
	Medicine addMedicine(Medicine medicine);
	void updateMedicine(int quantity,double price,int id);
	boolean deleteMedicine(int id);
	List<Medicine> getAllMedicine();
}
