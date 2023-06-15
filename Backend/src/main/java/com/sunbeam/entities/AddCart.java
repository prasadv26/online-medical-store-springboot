package com.sunbeam.entities;

import java.util.Date;

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

@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Table(name = "addcart")
@Entity
public class AddCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int quantity;
	private Date createDate;

	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "userId")
	private User user;

	public AddCart(int cartId, int quantity, Date createDate) {
		this.cartId = cartId;
		this.quantity = quantity;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "AddCart [cartId=" + cartId + ", quantity=" + quantity + ", createDate=" + createDate + ", user=" + user
				+ "]";
	}

}
