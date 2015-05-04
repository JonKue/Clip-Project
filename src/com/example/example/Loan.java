package com.example.example;

class Loan {
    // Data Members

    private int id;
    private String companyName;
    private int amount;
    private EnumClasses.ApplicationStatus applicationStatus;
//    private int remainingBalance;
//    private int interestRate;
//    private Calendar dueDate;
//    private int dueAmount;

    public Loan(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public EnumClasses.ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }
    public void setApplicationStatus(EnumClasses.ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    public void setApplicationStatus(String applicationStatus) {
        int i;
        this.applicationStatus = EnumClasses.ApplicationStatus.NONE;
        for(i=0; i<EnumClasses.ApplicationStatus.values().length; i++)
        {
            if(applicationStatus.equals(EnumClasses.ApplicationStatus.values()[i].toString()))
                this.applicationStatus = EnumClasses.ApplicationStatus.values()[i];
        }

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

//    public int getRemainingBalance() {
//        return remainingBalance;
//    }
//
//    public void setRemainingBalance(int remainingBalance) {
//        this.remainingBalance = remainingBalance;
//    }
//
//    public int getDueAmount() {
//        return dueAmount;
//    }
//
//    public void setDueAmount(int dueAmount) {
//        this.dueAmount = dueAmount;
//    }
//
//    public Calendar getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(Calendar dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public int getInterestRate() {
//        return interestRate;
//    }
//
//    public void setInterestRate(int interestRate) {
//        this.interestRate = interestRate;
//    }

    // Method for reminder of due date
//    public String dueDateReminder(Calendar currentDate){
//        String reminder = "";
//
//        return reminder;
//    }
}
