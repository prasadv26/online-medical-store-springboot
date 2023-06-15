package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock")
@Entity
public class Stock {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	private int stockCount;

}
