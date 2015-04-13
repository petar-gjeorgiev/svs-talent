package com.Seavus.AliExpress.Templates.Hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Seavus.AliExpress.Model.Account;
import com.Seavus.AliExpress.Model.Bill;
import com.Seavus.AliExpress.Model.CreditCart;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

@Component
public class HibernateDaoTemplate {

	private Transaction tx;
	private Session session;

	private Product product;
	private Set<Product> products;

	@Autowired
	public HibernateDaoTemplate(Product product, Set<Product> products) {
		this.product = product;
		this.products = products;
	}

	private HibernateSessionSetter saveSetter = new HibernateSessionSetter() {

		public void setSession(Session session, Object object) {
			session.save(object);
		}
	};

	private HibernateSessionSetter updateSetter = new HibernateSessionSetter() {

		public void setSession(Session session, Object object) {
			session.update(object);
		}
	};

	private HibernateSessionProductIdSetter deleteProductSetter = new HibernateSessionProductIdSetter() {

		public void setSession(Session session, String id) {
			session.delete((Product) session.get(Product.class, id));
		}
	};

	private HibernateSessionProductById getProductSetter = new HibernateSessionProductById() {

		public Product setSession(Session session, String id) {
			return (Product) session.get(Product.class, id);
		}

	};

	private GetByIdSetter getCartSetter = new GetByIdSetter() {

		@Override
		public CreditCart setSession(Session session, int id) {
			return (CreditCart) session.get(CreditCart.class, id);
		}
	};

	private GetByIdSetter getAccountSetter = new GetByIdSetter() {

		@Override
		public Account setSession(Session session, int id) {
			return (Account) session.get(Account.class, id);
		}
	};

	private DeleteSetter deleteCartSetter = new DeleteSetter() {

		@Override
		public void setSession(Session session, int id) {
			session.delete(getCartSetter.setSession(session, id));
		}
	};

	private DeleteSetter deleteAccountSetter = new DeleteSetter() {

		@Override
		public void setSession(Session session, int id) {
			session.delete(getAccountSetter.setSession(session, id));
		}
	};

	public void commit() {
		try {
			if (!tx.wasCommitted())
				tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	public void transaction(SessionFactory factory) {
		if (session == null) {

			try {
				session = factory.openSession();
				tx = session.beginTransaction();
			} catch (Exception e) {
				tx.rollback();
			}

		} else {
			session.close();
			session = factory.openSession();
			tx = session.beginTransaction();
		}

	}

	public void registerTransaction(SessionFactory factory, Object o) {
		transaction(factory);
		saveSetter.setSession(session, o);
		commit();
	}

	public void updateTransaction(SessionFactory factory, Object o) {
		transaction(factory);
		updateSetter.setSession(session, o);
		commit();
	}

	public void deleteProductTransaction(SessionFactory factory, String id) {
		transaction(factory);
		deleteProductSetter.setSession(session, id);
		commit();
	}

	public void closeFactory(SessionFactory factory) {
		if (factory != null) {
			factory.close();
		}
	}

	public Product getProductTransaction(SessionFactory factory, String id) {
		Product p = product;
		transaction(factory);
		p = getProductSetter.setSession(session, id);
		commit();
		return p;
	}

	public Criteria listAllProducts(SessionFactory factory) {
		transaction(factory);
		Criteria c = session.createCriteria(Product.class);
		commit();
		return c;
	}

	public Criteria listAllShoppingBaskets(SessionFactory factory) {
		transaction(factory);
		Criteria c = session.createCriteria(ShoppingBasket.class);
		commit();
		return c;
	}

	public Criteria getTotalSum(SessionFactory factory, int id) {
		transaction(factory);
		Criteria c = session.createCriteria(ShoppingBasket.class);
		c.add(Restrictions.eq("id", id));
		commit();
		return c;
	}

	public Set<Product> listProducts(SessionFactory factory, int id) {
		transaction(factory);
		Criteria c = session.createCriteria(Bill.class);
		c.add(Restrictions.eq("basket.id", id));

		@SuppressWarnings("unchecked")
		List<Bill> bills = c.list();
		Set<Product> res = products;
		Product p = product;
		for (int i = 0; i < bills.size(); i++) {
			String productid = bills.get(i).getProduct().getId();
			int quantity = bills.get(i).getQuantity();
			p = getProductTransaction(factory, productid);
			p.setQuantity(quantity);
			res.add(p);
		}
		commit();
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<CreditCart> listCarts(SessionFactory factory) {
		transaction(factory);
		Criteria c = session.createCriteria(CreditCart.class);
		commit();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Account> listAccounts(SessionFactory factory) {
		transaction(factory);
		Criteria c = session.createCriteria(Account.class);
		commit();
		return c.list();
	}

	public CreditCart getCartById(SessionFactory factory, int id) {
		transaction(factory);
		CreditCart cart = (CreditCart) getCartSetter.setSession(session, id);
		commit();
		return cart;
	}

	public void deleteCart(SessionFactory factory, int id) {
		transaction(factory);
		deleteCartSetter.setSession(session, id);
		commit();
	}

	public void deleteAccount(SessionFactory factory, int id) {
		transaction(factory);
		deleteAccountSetter.setSession(session, id);
		commit();
	}

	public Account getAccount(SessionFactory factory, int id) {
		transaction(factory);
		Account a = (Account) getAccountSetter.setSession(session, id);
		commit();
		return a;
	}

	public Account getAccountByCredentials(SessionFactory factory,
			String email, String password) {
		transaction(factory);
		Criteria c = session.createCriteria(Account.class);
		c.add(Restrictions.eq("email", email));
		c.add(Restrictions.eq("password", password));
		Account a = null;
		if (c.list().size() != 0) {
			a = (Account) c.list().get(c.list().size() - 1);
		}
		commit();
		return a;
	}
}
