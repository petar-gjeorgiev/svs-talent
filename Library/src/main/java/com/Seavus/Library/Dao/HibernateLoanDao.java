package com.Seavus.Library.Dao;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Model.Loan;

public interface HibernateLoanDao {

	public void register(Loan object);
	
	public void setFactory(SessionFactory factory);
	
	public void closeFactory();

}
