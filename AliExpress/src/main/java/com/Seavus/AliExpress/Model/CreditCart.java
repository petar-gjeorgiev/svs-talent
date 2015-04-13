package com.Seavus.AliExpress.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CreditCart {

	@Id
	@GeneratedValue
	private int id;

	private int balance;

	@OneToMany(mappedBy = "creditCart")
	private Set<Account> accounts;

	public CreditCart() {

	}

	public CreditCart(int id, int balance, Set<Account> accounts) {
		super();
		this.id = id;
		this.balance = balance;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return String.format("%-5d %-10d", id,balance);
	}

}
