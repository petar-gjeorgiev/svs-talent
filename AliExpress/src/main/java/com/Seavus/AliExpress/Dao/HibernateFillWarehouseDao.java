package com.Seavus.AliExpress.Dao;

import org.hibernate.SessionFactory;

public interface HibernateFillWarehouseDao extends FillWarehouseDao {

	public void setFactory(SessionFactory factory);
	
	public void closeFactory();
}
