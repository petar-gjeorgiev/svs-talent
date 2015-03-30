package com.Seavus.Library.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Seavus.Library.Dao.FactoryDao;
import com.Seavus.Library.Model.Book;

public class HibernateBookDaoImpl implements FactoryDao {

	private SessionFactory sessionFactory = null;

	public void registerBook(Book book) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void listAllBooks() { // String to return
		StringBuilder sb = new StringBuilder();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Book.class);
		@SuppressWarnings("unchecked")
		List<Book> results = cr.list();
		for (Book b : results) {
			sb.append(b + "\n");
		}
		System.out.println(sb.toString());
		session.close();
	}

	public void updateBook(Book book) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			String hql = "UPDATE Book set title = :title WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("title", book.getTitle());
			query.setParameter("id", book.getId());
			query.executeUpdate();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
		
		
		
//		Session session = sessionFactory.openSession();
//		Transaction tx = null;
//
//		try {
//			tx = session.beginTransaction();
//			Book b = (Book) session.get(Book.class, book.getId());
//			b.setTitle(book.getTitle());
//			session.update(b);
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null)
//				tx.rollback();
//		} finally {
//			session.close();
//		}

	}

	public void unregisterBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book b = (Book) session.get(Book.class, book.getId());
			session.delete(b);
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
