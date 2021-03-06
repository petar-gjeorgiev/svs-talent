package com.Seavus.Library.Dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;

public interface HibernateMemberDao {

	public void register(Member object);
	
	public void setFactory(SessionFactory factory);
	
	public void closeFactory();

	public void registerMemberShip(Membership registerMembership);
	
	public Member getMemberById(long id);
	
	public List<Member> listAllMembers();
	
}
