package com.example.clip;

import java.util.Date;

public class FinancialState {
	private String date; 
	private int cash;
	private String assets;
	private String liabilities;
	private String creditCards;
	private String other;
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public String getAssets() {
		return assets;
	}
	public void setAssets(String assets) {
		this.assets = assets;
	}
	public String getLiabilities() {
		return liabilities;
	}
	public void setLiabilities(String liabilities) {
		this.liabilities = liabilities;
	}
	public String getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(String creditCard1) {
		this.creditCards = creditCard1;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	

	// Constructor
	public FinancialState(String date) {
		// TODO Auto-generated constructor stub
		this.date = date;
	}

}
