package com.Seavus.Library.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Seavus.Library.Dao.HibernateBookDao;
import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateBookDaoImpl implements HibernateBookDao {

	private HibernateDaoTemplate template = new HibernateDaoTemplate();

	private SessionFactory sessionFactory = null;

	public void register(Book object) {
		template.registerTransaction(sessionFactory, object);
	}

	public List<Book> list() {

		List<Book> books = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Book.class);

		@SuppressWarnings("unchecked")
		List<Book> results = cr.list();

		for (Book b : results) {
			books.add(b);
		}
		session.close();
		return books;
	}

	public void update(Book object) {
		template.updateTransaction(sessionFactory, object);
	}

	public void unregister(long id) {
		template.deleteBookTransaction(sessionFactory, id);
	}

	/**
	 * Made for the first versions .. Not needed
	 */
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
		template.closeFactory(this.sessionFactory);
	}

}
