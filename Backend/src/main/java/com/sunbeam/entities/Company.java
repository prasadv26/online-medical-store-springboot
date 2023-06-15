
package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	private String companyName;
	private String companyDesc;
	private String contact;
	private String location;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "company-movement")
	private List<Medicine> medicineList;

	public Company() {
		this.medicineList = new ArrayList<Medicine>();
	}

	public Company(int companyId, String companyName, String companyDesc, String contact, String location,
			Address address, List<Medicine> medicineList) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyDesc = companyDesc;
		this.contact = contact;
		this.location = location;
		this.address = address;
		this.medicineList = medicineList;
	}

	public Company(int companyId, String companyName, String companyDesc, String contact, String location) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyDesc = companyDesc;
		this.contact = contact;
		this.location = location;
		this.address = new Address();
		this.medicineList = new ArrayList<Medicine>();
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyDesc=" + companyDesc
				+ ", contact=" + contact + ", location=" + location + ", address=" + address + "]";
	}

}
