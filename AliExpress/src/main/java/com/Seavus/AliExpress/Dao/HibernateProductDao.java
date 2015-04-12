package com.Seavus.AliExpress.Dao;

import org.hibernate.SessionFactory;

public interface HibernateProductDao extends ProductDao {

	public void setFactory(SessionFactory factory);
	
	public void closeFactory();
	
}
