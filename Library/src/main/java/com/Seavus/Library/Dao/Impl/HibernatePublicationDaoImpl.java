package com.Seavus.Library.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import com.Seavus.Library.Templates.Hibernate.HibernateDaoTemplate;

public class HibernatePublicationDaoImpl implements HibernatePublicationDao {

	private SessionFactory sessionFactory;
	private HibernateDaoTemplate template = new HibernateDaoTemplate();

	public void register(Publication object) {
		template.registerTransaction(sessionFactory, object);
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
		template.updateTransaction(sessionFactory, object);
	}

	public void unregister(long id) {
		template.deleteBookTransaction(sessionFactory, id);
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
		template.closeFactory(this.sessionFactory);
	}

	public Publication getPublicationById(long id) {
		Publication publication = null;
		template.getPublicationById(sessionFactory, publication, id);
		return publication;
	}

}
