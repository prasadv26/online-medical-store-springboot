
package com.sunbeam.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineId;
	private String medicineName;
	private String medicineDesc;
	private double price;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mfgDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expDate;
	private String thumbnail;
	private int quantity;

	@OneToOne(targetEntity = Stock.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "stockId")
	private Stock stock;

	@ManyToOne
	@JsonBackReference(value = "category-movement")
	@JoinColumn(name = "categoryId")
	private Category category;

	@ManyToOne
	@JsonBackReference(value = "company-movement")
	@JoinColumn(name = "companyId")
	private Company company;

//	@ManyToOne
//	@JsonBackReference(value = "order-movement")
//	@JoinColumn(name = "orderId")
//	private OrderNew order;

	public Medicine() {

	}

	public Medicine(int medicineId, String medicineName, String medicineDesc, double price, Date mfgDate, Date expDate,
			int quantity,String thumbnail) {
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineDesc = medicineDesc;
		this.price = price;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.quantity = quantity;
		this.thumbnail= thumbnail;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineDesc="
				+ medicineDesc + ", price=" + price + ", mfgDate=" + mfgDate + ", expDate=" + expDate + ", quantity="
				+ quantity + ", stock=" + stock + ", category=" + category + ", company=" + company
				+ "]";
	}

}
