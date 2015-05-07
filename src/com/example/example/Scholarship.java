package com.example.example;

public class Scholarship extends FinancialSupport {
    private int id;
    private String name;
    private String requirement;
    private int amount;
    private EnumClasses.ApplicationStatus applicationStatus;

    public Scholarship(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public EnumClasses.ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        int i;
        this.applicationStatus = EnumClasses.ApplicationStatus.NONE;
        for (i = 0; i < EnumClasses.ApplicationStatus.values().length; i++) {
            if (applicationStatus.equals(EnumClasses.ApplicationStatus.values()[i].toString()))
                this.applicationStatus = EnumClasses.ApplicationStatus.values()[i];
        }

    }

    @Override
    public void setApplicationStatus(EnumClasses.ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
