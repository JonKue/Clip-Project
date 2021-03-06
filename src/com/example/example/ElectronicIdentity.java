package com.example.example;

class ElectronicIdentity {

    //private variables
    private final int _id;

    private String name;
    private String website;
    private String userName;
    private String passWord;

    public ElectronicIdentity(int _id) {
        super();
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int get_id() {
        return _id;
    }


}