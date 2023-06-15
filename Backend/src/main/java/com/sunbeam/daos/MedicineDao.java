package com.sunbeam.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Medicine;

public interface MedicineDao extends JpaRepository<Medicine, Integer> {

	Medicine findByMedicineId(int id);

	Medicine findByMedicineName(String name);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = " update medicine set quantity=quantity+:quantity,price =:price where medicine_id=:medicineId", nativeQuery = true)
	public void updateMedicine(@Param("quantity") int quantity, @Param("price") double price,
			                   @Param("medicineId") int medicineId);

	

}

//quantity
//name
//price
