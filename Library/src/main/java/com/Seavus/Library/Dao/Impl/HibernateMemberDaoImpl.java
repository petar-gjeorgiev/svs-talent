package com.Seavus.Library.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Seavus.Library.Dao.HibernateMemberDao;
import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;
import com.Seavus.Library.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateMemberDaoImpl implements HibernateMemberDao {

	private SessionFactory sessionFactory;
	private HibernateDaoTemplate template = new HibernateDaoTemplate();

	public void register(Member object) {
		template.registerTransaction(sessionFactory, object);
	}

	public void setFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	public void closeFactory() {
		template.closeFactory(this.sessionFactory);
	}

	public void registerMemberShip(Membership registerMembership) {
		template.registerTransaction(sessionFactory, registerMembership);
	}

	public Member getMemberById(long id) {
		Member member = new Member();
		template.getMemberById(sessionFactory, member, id);
		return member;
	}

	@SuppressWarnings("unchecked")
	public List<Member> listAllMembers() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Member.class);
		session.close();
		return cr.list();
	}

}
