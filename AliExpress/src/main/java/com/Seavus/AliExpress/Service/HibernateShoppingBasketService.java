package com.Seavus.AliExpress.Service;

import org.hibernate.SessionFactory;

public interface HibernateShoppingBasketService extends ShoppingBasketService {

	public void setFactory(SessionFactory factory);

	public void closeFactory();
	
}
