package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@NoArgsConstructor
@Data
@Table(name = "orderdetails")
@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;
	private int quantity;
	private double amount;

	@OneToOne(targetEntity = OrderNew.class)
	@JoinColumn(name = "orderId")
	private OrderNew order;

}
