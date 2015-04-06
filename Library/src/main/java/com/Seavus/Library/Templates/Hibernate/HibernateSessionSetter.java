package com.Seavus.Library.Templates.Hibernate;

import org.hibernate.Session;

public interface HibernateSessionSetter {

	public void setSession(Session session,Object object);
	
}
