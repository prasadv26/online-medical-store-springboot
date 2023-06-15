package com.sunbeam.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String role;
	private String password;
	private String phone;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address;

	@OneToMany(mappedBy = "user")
	@JsonManagedReference(value = "orderU-movement")
	private List<OrderNew> orderList;

	public User(int id, String first_name, String last_name, String email, String role, String password, String phone) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
		this.password = password;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", role=" + role + ", password=" + password + ", phone=" + phone + ", address=" + address + "]";
	}

}
