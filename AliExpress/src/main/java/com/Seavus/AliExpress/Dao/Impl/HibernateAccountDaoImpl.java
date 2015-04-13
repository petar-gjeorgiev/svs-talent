package com.Seavus.AliExpress.Dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Seavus.AliExpress.Dao.HibernateAccountDao;
import com.Seavus.AliExpress.Model.Account;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

@Repository
public class HibernateAccountDaoImpl implements HibernateAccountDao {

	@Autowired
	private HibernateDaoTemplate template;

	@Autowired
	private SessionFactory factory;

	public HibernateAccountDaoImpl() {
		
	}
	
	public HibernateAccountDaoImpl(HibernateDaoTemplate template) {
		this.template = template;
	}

	@Override
	public void create(Account account) {
		template.registerTransaction(factory, account);
	}

	@Override
	public void delete(int id) {
		template.deleteAccount(factory, id);
	}

	@Override
	public void update(Account a) {
		template.updateTransaction(factory, a);
	}

	@Override
	public List<Account> list() {
		return template.listAccounts(factory);
	}

	@Override
	public Account getAccountById(int id) {
		return template.getAccount(factory, id);
	}

	@Override
	public void setFactory(SessionFactory factory) {
		if (this.factory == null) {
			this.factory = factory;
		}
	}

	@Override
	public void closeFactory() {
		this.factory.close();
	}

	@Override
	public Account getByCredentials(String email, String password) {
		return template.getAccountByCredentials(factory, email, password);
	}

}
