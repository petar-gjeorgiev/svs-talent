package com.Seavus.AliExpress.Templates.Hibernate;

import org.hibernate.Session;

import com.Seavus.AliExpress.Model.Product;

public interface HibernateSessionProductById {

	public Product setSession(Session session, String id);
	
}
