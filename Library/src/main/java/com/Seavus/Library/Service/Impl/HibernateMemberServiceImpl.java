package com.Seavus.Library.Service.Impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Dao.HibernateMemberDao;
import com.Seavus.Library.Dao.Impl.HibernateMemberDaoImpl;
import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;
import com.Seavus.Library.Service.HibernateMemberService;

public class HibernateMemberServiceImpl implements HibernateMemberService {

	HibernateMemberDao memberDao = new HibernateMemberDaoImpl();
	
	public void register(Member m) {
		memberDao.register(m);
	}

	public void setFactory(SessionFactory factory) {
		memberDao.setFactory(factory);
	}

	public void closeFactory() {
		memberDao.closeFactory();
	}

	public void registerMemberShip(Membership registerMembership) {
		memberDao.registerMemberShip(registerMembership);
	}

	public Member getMemberById(long id) {
		return memberDao.getMemberById(id);
	}

	public List<Member> listAllMembers() {
		return memberDao.listAllMembers();
	}

}
