package com.example.example;

class FinancialSupport {
    // Data Members
    private int id;
    private int amount;
    private EnumClasses.ApplicationStatus applicationStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

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

    public void setApplicationStatus(EnumClasses.ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
