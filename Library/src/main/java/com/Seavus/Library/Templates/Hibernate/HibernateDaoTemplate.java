package com.Seavus.Library.Templates.Hibernate;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Publication;

public class HibernateDaoTemplate {

	private Transaction tx;
	private Session session;
	private HibernateSessionSetter saveSetter = new HibernateSessionSetter() {
		
		public void setSession(Session session, Object object) {
			session.save(object);
		}
	};
	
	private HibernateSessionSetter updateSetter = new HibernateSessionSetter() {
		
		public void setSession(Session session, Object object) {
			session.update(object);
		}
	};
	
	private HibernateSessionIdSetter deleteBookSetter = new HibernateSessionIdSetter() {
		
		public void setSession(Session session, long id) {
			session.delete((Book) session.get(Book.class, id));
		}
	};
	
	private HibernateGetByIdSetter memberById = new HibernateGetByIdSetter() {
		
		public void setSession(Object member, long id) {
			member = (Member) session.get(Member.class, id);
		}
	};
	
	private HibernateGetByIdSetter publicationById = new HibernateGetByIdSetter() {
		
		public void setSession(Object publication, long id) {
			publication = (Publication) session.get(Publication.class, id);
		}
	};
	
	private HibernateSessionCriteriaSetter listSetter = new HibernateSessionCriteriaSetter() {
		
		public Criteria setSession(Session session, String clName) {
			return session.createCriteria(clName.getClass());
		}
	};
	
	public void transaction(SessionFactory factory) {
		session = factory.openSession();
		tx = session.beginTransaction();
	}
	
	public void commit() {
		tx.commit();
	}
	
	public void registerTransaction (SessionFactory factory,Object o) {
		transaction(factory);
		saveSetter.setSession(session, o);
		commit();
	}
	
	public void updateTransaction(SessionFactory factory,Object o) {
		transaction(factory);
		updateSetter.setSession(session, o);
		commit();
	}
	
	public void deleteBookTransaction(SessionFactory factory,long id) {
		transaction(factory);
		deleteBookSetter.setSession(session, id);
		commit();
	}
	
	public void closeFactory(SessionFactory factory) {
		if (factory != null) {
			factory.close();
		}
	}
	
	public void getMemberById(SessionFactory factory,Object member,long id) {
		transaction(factory);
		memberById.setSession(member, id);
		commit();
	}
	
	public void getPublicationById(SessionFactory factory,Object member,long id) {
		transaction(factory);
		publicationById.setSession(member, id);
		commit();
	}
	
	public Criteria listAllPublications(SessionFactory factory) {
		transaction(factory);
		Criteria res = listSetter.setSession(session, "Publication");
		commit();
		return res;
	}
	
}
