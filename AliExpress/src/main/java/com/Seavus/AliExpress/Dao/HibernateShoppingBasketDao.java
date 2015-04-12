package com.Seavus.AliExpress.Dao;

import org.hibernate.SessionFactory;

public interface HibernateShoppingBasketDao extends ShoppingBasketDao {

	public void setFactory(SessionFactory factory);
	
	public void closeFactory();
	
}
