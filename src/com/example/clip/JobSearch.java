package com.example.clip;

import java.util.Date;

public class JobSearch {
	private String jobName;
	private Date date;
	private String status;
	private String note;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public JobSearch(String jobName) {
		super();
		this.jobName = jobName;
	}
	
}
