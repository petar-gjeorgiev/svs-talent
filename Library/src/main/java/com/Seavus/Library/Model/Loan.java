package com.Seavus.Library.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Loan {

	@Id
	@GeneratedValue
	private long id;

	private Date startDate;

	private Date endDate;

	@ManyToOne
	private Member member;

	@ManyToOne
	private Publication publication;

	public Loan(long id, Date startDate, Date endDate, Member member,
			Publication publication) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.member = member;
		this.publication = publication;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

}
