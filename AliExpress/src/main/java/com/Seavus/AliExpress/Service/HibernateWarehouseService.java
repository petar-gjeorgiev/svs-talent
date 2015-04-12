package com.Seavus.AliExpress.Service;

import org.hibernate.SessionFactory;

public interface HibernateWarehouseService extends FillWarehouseService {

	public void setFactory(SessionFactory factory);

	public void closeFactory();

}
