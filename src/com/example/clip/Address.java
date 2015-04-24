package com.example.clip;

public class Address {
	    // Data Members
	    private int streetNum;
	    private String streetName;
	    private String streetDeg;
	    private String addAddressInfo;
	    private String cityName;
	    private String stateAbb;
	    private int zipCode;
	    private String countryName;

	    public int getStreetNum() {
	        return streetNum;
	    }

	    public void setStreetNum(int streetNum) {
	        this.streetNum = streetNum;
	    }

	    public String getStreetName() {
	        return streetName;
	    }

	    public void setStreetName(String streetName) {
	        this.streetName = streetName;
	    }

	    public String getStreetDeg() {
	        return streetDeg;
	    }

	    public void setStreetDeg(String streetDeg) {
	        this.streetDeg = streetDeg;
	    }

	    public String getAddAddressInfo() {
	        return addAddressInfo;
	    }

	    public void setAddAddressInfo(String addAddressInfo) {
	        this.addAddressInfo = addAddressInfo;
	    }

	    public String getCityName() {
	        return cityName;
	    }

	    public void setCityName(String cityName) {
	        this.cityName = cityName;
	    }

	    public String getStateAbb() {
	        return stateAbb;
	    }

	    public void setStateAbb(String stateAbb) {
	        this.stateAbb = stateAbb;
	    }

	    public int getZipCode() {
	        return zipCode;
	    }

	    public void setZipCode(int zipCode) {
	        this.zipCode = zipCode;
	    }

	    public String getCountryName() {
	        return countryName;
	    }

	    public void setCountryName(String countryName) {
	        this.countryName = countryName;
	    }
	    
	    // Print entire address in standard US Mail format
	    public String displayAddressUSMailFormat(){
	        return String.format(getStreetNum() + " " + getStreetName() + " " + getStreetDeg() + "\n" + getAddAddressInfo() + "\n" + getCityName() + " " + getStateAbb() + " " + getZipCode() + "\n" + getCountryName());
	    }
	   
	    // Print only the city and state in the format "City, StateCode"
	    public String displayAddressCityStateFormat(){
	        return String.format(getCityName() + ", " + getStateAbb());
	    }
	}


