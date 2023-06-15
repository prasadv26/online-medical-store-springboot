package com.sunbeam.entities;

import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@Entity
public class OrderNew {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	private double totalCost;

	@ManyToOne
	@JsonBackReference(value = "orderU-movement")
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(targetEntity = Medicine.class)
	//@JsonManagedReference(value = "order-movement")
	private List<Medicine> medicine;

	public OrderNew(int orderId, Date orderDate, double totalCost) {
		this.order_id = orderId;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "OrderNew [orderId=" + order_id + ", orderDate=" + orderDate + ", totalCost=" + totalCost + ", user="
				+ user + "]";
	}

}
