package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "address")
@Entity
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private String postalCode;
}
