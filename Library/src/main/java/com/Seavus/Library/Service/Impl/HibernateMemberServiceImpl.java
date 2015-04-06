package com.Seavus.Library.Service.Impl;

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

}
