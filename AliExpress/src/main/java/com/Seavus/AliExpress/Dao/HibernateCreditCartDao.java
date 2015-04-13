package com.Seavus.AliExpress.Dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Model.CreditCart;

public interface HibernateCreditCartDao {

	public void create(CreditCart cart);

	public void delete(int id);

	public void update(CreditCart cart);

	public List<CreditCart> list();
	
	public CreditCart getCartById(int id);
	
	public void setFactory(SessionFactory factory);
	
	public void closeFactory();
	
}
