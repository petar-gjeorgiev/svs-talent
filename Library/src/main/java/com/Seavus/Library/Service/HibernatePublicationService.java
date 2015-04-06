package com.Seavus.Library.Service;

import java.util.List;

import com.Seavus.Library.Model.Publication;

public interface HibernatePublicationService {

	public void createSessionFactory();

	public void update(Publication b);

	public void register(Publication b);

	public List<Publication> list();

	public void unregister(long id);

	public void closeSession();
	
}
