package com.Seavus.AliExpress.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String email;

	private String password;

	@ManyToOne
	private CreditCart creditCart;

	public Account() {

	}

	public Account(int id, String name, String email, String password,
			CreditCart creditCart) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.creditCart = creditCart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CreditCart getCreditCart() {
		return creditCart;
	}

	public void setCreditCart(CreditCart creditCart) {
		this.creditCart = creditCart;
	}

	@Override
	public String toString() {
		return String.format("%-5d %-10s %-15s", id, name, email);
	}

}
