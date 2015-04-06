package com.Seavus.Library.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Seavus.Library.Dao.HibernatePublicationDao;
import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Model.Loan;
import com.Seavus.Library.Model.Magazine;
import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;
import com.Seavus.Library.Model.Publication;

public class HibernatePublicationDaoImpl implements HibernatePublicationDao {

	private SessionFactory sessionFactory;

	public void register(Publication object) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	public List<Publication> list() {
		List<Publication> publications = new ArrayList<Publication>();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Publication.class);

		@SuppressWarnings("unchecked")
		List<Publication> results = cr.list();

		for (Publication b : results) {
			publications.add(b);
		}
		session.close();
		return publications;
	}

	public void update(Publication object) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();

		try {
			tx = session.beginTransaction();
			session.update(object);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void unregister(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete((Book) session.get(Book.class, id));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void createSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			SessionFactory sessionFactory = configuration
					.addAnnotatedClass(Book.class)
					.addAnnotatedClass(Magazine.class)
					.addAnnotatedClass(Loan.class)
					.addAnnotatedClass(Member.class)
					.addAnnotatedClass(Membership.class)
					.buildSessionFactory(serviceRegistry);
			this.sessionFactory = sessionFactory;
		}
	}

	public void setFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	public void closeFactory() {
		if (this.sessionFactory != null) {
			this.sessionFactory.close();
		}
	}

	public Publication getPublicationById(long id) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		Publication publication = null;
		
		try {
			tx = session.beginTransaction();
			publication = (Publication) session.get(Publication.class, id);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return publication;
	}

}
