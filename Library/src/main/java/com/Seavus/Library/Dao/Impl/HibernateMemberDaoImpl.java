package com.Seavus.Library.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Seavus.Library.Dao.HibernateMemberDao;
import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;
import com.Seavus.Library.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateMemberDaoImpl implements HibernateMemberDao {

	private SessionFactory sessionFactory = null;
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
