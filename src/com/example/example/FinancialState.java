package com.example.example;

import java.util.Date;

public class FinancialState {
	 //private variables
    private final int _id;
	
	private String date; 
	private String cash;
	private String assets;
	private String liabilities;
	private String creditCards;
	private String other;
	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
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
	
	

	public int get_id() {
		return _id;
	}
	// Constructor
	public FinancialState(int _id) {
		// TODO Auto-generated constructor stub
		this._id = _id;
	}

}
