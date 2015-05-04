package com.example.example;



public class Goal {
    // Data fields
    private String name;
    private GoalType type;


    public String getType() {
        return type.toString();
    }
    public void setType(GoalType type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Goal() {
        super();
        //this.name = name;
    }


}