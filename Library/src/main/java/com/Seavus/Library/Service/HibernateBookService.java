package com.Seavus.Library.Service;

public interface HibernateBookService {

	public void updateBook();

	public void registerBook();

	public void listAllBooks();

	public void unregisterBook();

	public void appInfo();

	public void createSessionFactory();
	
	public void closeSession();
	
}
