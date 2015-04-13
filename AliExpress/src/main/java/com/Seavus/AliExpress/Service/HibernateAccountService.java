package com.Seavus.AliExpress.Service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Model.Account;

public interface HibernateAccountService {

	public void create(Account account);

	public void delete(int id);

	public void update(Account a);

	public List<Account> list();

	public Account getAccountById(int id);

	public void setFactory(SessionFactory factory);

	public void closeFactory();

	public Account getAccountByCredentials(String email,String password);
	
}
