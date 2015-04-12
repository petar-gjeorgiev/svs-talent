package com.Seavus.AliExpress.Service;

import org.hibernate.SessionFactory;

public interface HibernateProductService extends ProductService {

	public void setFactory(SessionFactory factory);

	public void closeFactory();
}
