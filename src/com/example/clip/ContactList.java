package com.example.clip;

import java.util.Date;

public class ContactList {
	
	private ContactName name;
	private String affiliation;
	private Date establishedDate;
	private int timesUsed;
	private String comments;
	public ContactName getName() {
		return name;
	}
	public void setName(ContactName name) {
		this.name = name;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public Date getEstablishedDate() {
		return establishedDate;
	}
	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}
	public int getTimesUsed() {
		return timesUsed;
	}
	public void setTimesUsed(int timesUsed) {
		this.timesUsed = timesUsed;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public ContactList(ContactName name) {
		super();
		this.name = name;
		this.timesUsed = 0;
	}
	
	
}
