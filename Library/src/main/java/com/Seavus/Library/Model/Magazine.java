package com.Seavus.Library.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Publication {

	private String issn;

	public Magazine() {

	}

	public Magazine(long id, String title, String issn) {
		super(id, title);
		this.issn = issn;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

}
