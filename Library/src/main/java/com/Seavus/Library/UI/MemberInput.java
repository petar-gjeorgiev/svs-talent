package com.Seavus.Library.UI;

import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;

public interface MemberInput {

	public Member RegisterInput();
	
	public Membership RegisterMembership(Member m);
}
