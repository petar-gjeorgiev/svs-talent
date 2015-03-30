package com.Seavus.Library.Dao;

public interface HibernateBookDao extends JDBCBookDao {

	public void createSessionFactory();

	public void closeFactory();

}
