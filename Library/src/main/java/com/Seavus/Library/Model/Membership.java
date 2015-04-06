package com.Seavus.Library.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Membership {

	@Id
	@GeneratedValue
	private long id;

	private Date startDate;

	private Date endDate;

	private String membershipType;

	@OneToOne
	private Member member;

	public Membership() {
		
	}
	
	public Membership(long id, Date startDate, Date endDate,
			String membershipType, Member member) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.membershipType = membershipType;
		this.member = member;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
