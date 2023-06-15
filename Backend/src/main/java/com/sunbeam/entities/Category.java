package com.sunbeam.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "category")
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;

	
	private String category;

	private String categoryDesc;
	private String thumbnail;

	@OneToMany(mappedBy = "category")
	@JsonManagedReference(value = "category-movement")
	private List<Medicine> medicineList;

	public Category(int categoryId, String category, String categoryDesc,String thumbnail) {
		this.categoryId = categoryId;
		this.category = category;
		this.categoryDesc = categoryDesc;
		this.thumbnail=thumbnail;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category=" + category + ", categoryDesc=" + categoryDesc + "]";
	}
	
}
