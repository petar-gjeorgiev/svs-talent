package com.Seavus.Library.Dao;


public interface FactoryDao extends BookDao {

	public void createSessionFactory();
	
	public void closeFactory();
	
}
