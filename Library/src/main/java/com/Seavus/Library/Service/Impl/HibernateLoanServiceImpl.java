package com.Seavus.Library.Service.Impl;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Dao.HibernateLoanDao;
import com.Seavus.Library.Dao.Impl.HibernateLoanDaoImpl;
import com.Seavus.Library.Model.Loan;
import com.Seavus.Library.Service.HibernateLoanService;

public class HibernateLoanServiceImpl implements HibernateLoanService {

	public HibernateLoanDao loanDao = new HibernateLoanDaoImpl();
	
	public void register(Loan loan) {
		loanDao.register(loan);
	}

	public void setFactory(SessionFactory factory) {
		loanDao.setFactory(factory);
	}

	public void closeFactory() {
		loanDao.closeFactory();
	}

}
