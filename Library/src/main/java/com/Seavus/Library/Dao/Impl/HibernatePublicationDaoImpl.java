package com.Seavus.Library.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Seavus.Library.Dao.HibernatePublicationDao;
import com.Seavus.Library.Model.Publication;
import com.Seavus.Library.Templates.Hibernate.HibernateDaoTemplate;

public class HibernatePublicationDaoImpl implements HibernatePublicationDao {

	private SessionFactory sessionFactory;
	private HibernateDaoTemplate template = new HibernateDaoTemplate();

	public void register(Publication object) {
		template.registerTransaction(sessionFactory, object);
	}

	@SuppressWarnings("unchecked")
	public List<Publication> list() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Publication.class);
		return cr.list();
	//	return template.listAllPublications(sessionFactory).list();
	}

	public void update(Publication object) {
		template.updateTransaction(sessionFactory, object);
	}

	public void unregister(long id) {
		template.deleteBookTransaction(sessionFactory, id);
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
