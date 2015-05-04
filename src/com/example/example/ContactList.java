package com.example.example;

import java.util.Date;

public class ContactList {

    //private variables
    final int _id;
    private String name;
    private String affiliation;
    private String establishedDate;
    private String timesUsed;
    private String comments;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAffiliation() {
        return affiliation;
    }
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
    public String getEstablishedDate() {
        return establishedDate;
    }
    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = establishedDate;
    }
    public String getTimesUsed() {
        return timesUsed;
    }
    public void setTimesUsed(String timesUsed) {
        this.timesUsed = timesUsed;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public ContactList(int _id) {
        super();
        this._id = _id;
    }
    public int get_id() {
        return _id;
    }



}