package com.example.example;

import java.util.Calendar;

public class Loan extends FinancialSupport {
    // Data Members
    private int remainingBalance;
    private String companyName;
    private int interestRate;
    private Calendar dueDate;
    private int dueAmount;

    public int getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(int remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public int getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(int dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Loan(String companyName) {
        super();
        this.companyName = companyName;
    }

    // Method for reminder of due date
    public String dueDateReminder(Calendar currentDate){
        String reminder = "";

        return reminder;
    }
}
