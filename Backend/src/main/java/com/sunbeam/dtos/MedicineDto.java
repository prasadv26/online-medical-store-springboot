package com.sunbeam.dtos;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Medicine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicineDto {

	private int medicineId;
	private String medicineName;
	private String medicineDesc;
	private double price;
	private int quantity;
	private Date mfgDate;
	private Date expDate;

	private String companyName;

	private String category;

	public static MedicineDto fromEntity(Medicine medicine) {
		MedicineDto dto = new MedicineDto();
		BeanUtils.copyProperties(medicine, dto);
		dto.setCategory(medicine.getCategory().getCategory());
		dto.setCompanyName(medicine.getCompany().getCompanyName());
		return dto;

	}

}
