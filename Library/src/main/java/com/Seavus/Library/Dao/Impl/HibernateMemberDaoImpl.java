package com.Seavus.Library.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Seavus.Library.Dao.HibernateMemberDao;
import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;

public class HibernateMemberDaoImpl implements HibernateMemberDao {

	private SessionFactory sessionFactory = null;

	public void register(Member object) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void setFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	public void closeFactory() {
		if (this.sessionFactory != null) {
			this.sessionFactory.close();
		}
	}

	public void registerMemberShip(Membership registerMembership) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(registerMembership);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	public Member getMemberById(long id) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		Member member = new Member();
		try {
			tx = session.beginTransaction();
			member = (Member) session.get(Member.class, id);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return member;
	}

	public List<Member> listAllMembers() {
		List<Member> members = new ArrayList<Member>();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Member.class);

		@SuppressWarnings("unchecked")
		List<Member> results = cr.list();

		for (Member m : results) {
			members.add(m);
		}
		session.close();
		return members;
	}

}
