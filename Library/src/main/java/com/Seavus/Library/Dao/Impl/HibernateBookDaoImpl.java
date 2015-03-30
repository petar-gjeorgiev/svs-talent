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

import com.Seavus.Library.Dao.HibernateBookDao;
import com.Seavus.Library.Model.Book;

public class HibernateBookDaoImpl implements HibernateBookDao {

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

	public String listAllBooks() {
		StringBuilder sb = new StringBuilder();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Book.class);
		@SuppressWarnings("unchecked")
		List<Book> results = cr.list();

		String id1 = "ID";
		String isbn1 = "ISBN";
		String title1 = "TITLE";
		sb.append(String.format("%-4s %-8s %-15s", id1, isbn1, title1) + "\n");

		for (Book b : results) {
			sb.append(String.format("%-4d %-8s %-15s", b.getId(), b.getIsbn(),
					b.getTitle()) + "\n");
		}
		session.close();
		return sb.toString();
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
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void unregisterBook(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book b = (Book) session.get(Book.class, id);
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
