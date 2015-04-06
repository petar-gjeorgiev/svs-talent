package com.Seavus.Library.Templates.Hibernate;

import org.hibernate.Session;

public interface HibernateSessionIdSetter {

	public void setSession(Session session,long id);
	
}
