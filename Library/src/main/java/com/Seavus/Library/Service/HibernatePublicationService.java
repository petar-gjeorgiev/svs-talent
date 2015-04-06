package com.Seavus.Library.Service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Model.Publication;

public interface HibernatePublicationService {

	public void update(Publication b);

	public void register(Publication b);

	public List<Publication> list();

	public void unregister(long id);

	public void closeSession();

	public void setFactory(SessionFactory factory);

	public void closeFactory();

	public Publication getPublicationById(long id);
}
