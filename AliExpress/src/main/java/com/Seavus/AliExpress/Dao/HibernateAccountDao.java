package com.Seavus.AliExpress.Dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Model.Account;

public interface HibernateAccountDao {

	public void create(Account account);

	public void delete(int id);

	public void update(Account a);

	public List<Account> list();

	public Account getAccountById(int id);
	
	public Account getByCredentials (String email,String password);

	public void setFactory(SessionFactory factory);

	public void closeFactory();

}
