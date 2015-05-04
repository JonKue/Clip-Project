package com.example.example;

class JobSearch {
    private String jobName;
    private String date;
    private String status;
    private String note;

    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String string) {
        this.date = string;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public JobSearch() {
        super();
        //this.jobName = jobName;
    }

}