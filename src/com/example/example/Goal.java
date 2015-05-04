package com.example.example;


class Goal {
    // Data fields
    private String name;
    private GoalType type;


    public Goal() {
        super();
        //this.name = name;
    }

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


}