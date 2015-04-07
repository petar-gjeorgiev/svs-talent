package com.Seavus.Library.Templates.Hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;

public interface HibernateSessionCriteriaSetter {

	public Criteria setSession(Session session,String clName);
	
}
