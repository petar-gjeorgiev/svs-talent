package com.Seavus.Library.Templates.Hibernate;

import javassist.bytecode.stackmap.TypeData.ClassName;

import org.hibernate.Criteria;
import org.hibernate.Session;

public interface HibernateSessionCriteriaSetter {

	public Criteria setSession(Session session,ClassName clName);
	
}
