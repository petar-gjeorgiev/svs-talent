package com.Seavus.Library.Service.Impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Dao.HibernatePublicationDao;
import com.Seavus.Library.Dao.Impl.HibernatePublicationDaoImpl;
import com.Seavus.Library.Model.Publication;
import com.Seavus.Library.Service.HibernatePublicationService;

public class HibernatePublicationServiceImpl implements
		HibernatePublicationService {

	HibernatePublicationDao publicationDao = new HibernatePublicationDaoImpl();


	public void update(Publication b) {
		publicationDao.update(b);
	}

	public void register(Publication b) {
		publicationDao.register(b);
	}

	public List<Publication> list() {
		return publicationDao.list();
	}

	public void unregister(long id) {
		publicationDao.unregister(id);
	}

	public void closeSession() {
		publicationDao.closeFactory();
	}

	public void setFactory(SessionFactory factory) {
		publicationDao.setFactory(factory);
	}

	public void closeFactory() {
		publicationDao.closeFactory();
	}

	public Publication getPublicationById(long id) {
		return publicationDao.getPublicationById(id);
	}


}
