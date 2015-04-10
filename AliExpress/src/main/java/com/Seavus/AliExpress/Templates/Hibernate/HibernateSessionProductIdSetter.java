package com.Seavus.AliExpress.Templates.Hibernate;

import org.hibernate.Session;

public interface HibernateSessionProductIdSetter {

	public void setSession(Session session, String id);

}
