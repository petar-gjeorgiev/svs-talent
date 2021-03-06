package com.Seavus.AliExpress.Service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Seavus.AliExpress.Dao.HibernateAccountDao;
import com.Seavus.AliExpress.Model.Account;
import com.Seavus.AliExpress.Service.HibernateAccountService;

@Service
@Transactional
public class HibernateAccountServiceImpl implements HibernateAccountService {

	private HibernateAccountDao dao;

	public HibernateAccountServiceImpl() {
		
	}
	
	@Autowired
	public HibernateAccountServiceImpl(HibernateAccountDao dao) {
		this.dao = dao;
	}

	@Override
	public void create(Account account) {
		dao.create(account);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void update(Account a) {
		dao.update(a);
	}

	@Override
	public List<Account> list() {
		return dao.list();
	}

	@Override
	public Account getAccountById(int id) {
		return dao.getAccountById(id);
	}

	@Override
	public void setFactory(SessionFactory factory) {
		dao.setFactory(factory);
	}

	@Override
	public void closeFactory() {
		dao.closeFactory();
	}

	@Override
	public Account getAccountByCredentials(String email, String password) {
		return dao.getByCredentials(email, password);
	}

}
