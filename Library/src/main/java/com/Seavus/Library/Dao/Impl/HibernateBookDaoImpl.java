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

import com.Seavus.Library.Dao.HibernateBookDao;
import com.Seavus.Library.Model.Book;

public class HibernateBookDaoImpl implements HibernateBookDao {

	private SessionFactory sessionFactory = null;

	public void register(Book object) {
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

	public List<Book> list() {

		List<Book> books = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Book.class);

		@SuppressWarnings("unchecked")
		List<Book> results = cr.list();

		for (Book b : results) {
			books.add(new Book(b.getId(), b.getIsbn(), b.getTitle()));
		}
		session.close();
		return books;
	}

	public void update(Book object) {

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

			SessionFactory sessionFactory = configuration.addAnnotatedClass(
					Book.class).buildSessionFactory(serviceRegistry);
			this.sessionFactory = sessionFactory;
		}
	}

	public void closeFactory() {
		if (this.sessionFactory != null) {
			this.sessionFactory.close();
		}
	}

}
