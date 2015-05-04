package com.example.example;

public class User {

    //private variables
    static int userCount = 0;
    int _id;
    String _name;
    String _password;

    // Empty constructor
    public User(){

    }
    // constructor
    public User(int id, String name, String password){
        this._id = id;
        this._name = name;
        this._password = password;
    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPassword(){
        return this._password;
    }

    // setting phone number
    public void setPassword(String password){
        this._password = password;
    }
}