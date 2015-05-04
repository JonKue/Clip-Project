package com.example.example;

class CompanyInformation {

    private String comName;
    private String comProduct;
    private String phoneNum;
    private String location;
    private String keyFacts;
    private String reasons;
    private String resumeSubDate;
    private String interviewDate;
    private ApplicationStatus interviewResult;
    private String notes;

    public CompanyInformation() {
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComProduct() {
        return comProduct;
    }

    public void setComProduct(String comProduct) {
        this.comProduct = comProduct;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKeyFacts() {
        return keyFacts;
    }

    public void setKeyFacts(String keyFacts) {
        this.keyFacts = keyFacts;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getResumeSubDate() {
        return resumeSubDate;
    }

    public void setResumeSubDate(String resumeSubDate) {
        this.resumeSubDate = resumeSubDate;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public ApplicationStatus getInterviewResult() {
        return interviewResult;
    }

    private void setInterviewResult(ApplicationStatus interviewResult) {
        this.interviewResult = interviewResult;
    }
    public void setInterviewResult(String result) {
        this.setInterviewResult(ApplicationStatus.valueOf(result));
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
