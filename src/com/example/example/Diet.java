package com.example.example;

class Diet {
    // Date Members
    private final int _id;
    private String dietType;
    private String startDate;
    private String endDate;
    private String otherInfo;

    public String getDietType() {
        return dietType;
    }
    public void setDietType(String dietType) {
        this.dietType = dietType;
    }


    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public int get_id() {
        return _id;
    }
    public String getOtherInfo() {
        return otherInfo;
    }
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
    public Diet(int _id) {
        super();
        this._id = _id;
    }

}