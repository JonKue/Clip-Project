package com.example.example;

public class FinancialSupport {
    // Data Members
    private int amount;
    private EnumClasses.ApplicationStatus applicationStatus;

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public EnumClasses.ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }
    public void setApplicationStatus(EnumClasses.ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    // method to update application status
    public void updateApplicationStatus(EnumClasses.ApplicationStatus status){
        this.setApplicationStatus(status);
    }
}
