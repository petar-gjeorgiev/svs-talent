package com.Seavus.Library.Service;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Model.Loan;

public interface HibernateLoanService {

	public void register(Loan loan);

	public void setFactory(SessionFactory factory);

	public void closeFactory();

}
