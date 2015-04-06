package com.Seavus.Library.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private long id;

	private String email;

	private String name;

	@OneToOne(mappedBy = "member")
	private Membership membership;

	@OneToMany(mappedBy = "member")
	private Set<Loan> loans;
	
	public Member() {

	}

	public Member(long id, String email, String name, Membership membership) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.membership = membership;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

}
