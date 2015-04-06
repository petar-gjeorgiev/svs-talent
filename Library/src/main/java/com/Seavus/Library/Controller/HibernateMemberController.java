package com.Seavus.Library.Controller;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Service.HibernateMemberService;
import com.Seavus.Library.Service.Impl.HibernateMemberServiceImpl;
import com.Seavus.Library.UI.MemberInput;
import com.Seavus.Library.UI.Impl.MemberInputImpl;

public class HibernateMemberController {

	public HibernateMemberService service = new HibernateMemberServiceImpl();
	public MemberInput input = new MemberInputImpl();
	public Member currMember;
	
	public void registerMember() {
		currMember = input.RegisterInput();
		service.register(currMember);
	}
	
	public void registerMembership() {
		service.registerMemberShip(input.RegisterMembership(currMember));
	}
	
	public void closeFactory() {
		service.closeFactory();
	}
	
	public void setFactory(SessionFactory factory) {
		service.setFactory(factory);
	}
	
}
