package com.Seavus.Library.Dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Model.Publication;

public interface HibernatePublicationDao {

	public void register(Publication object);

	public List<Publication> list();

	public void update(Publication object);

	public void unregister(long id);

	public void setFactory(SessionFactory factory);
	
	public void closeFactory();
	
	public Publication getPublicationById(long id);
	
}
