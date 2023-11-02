package com.wwac.dto;

import java.time.LocalDate;

public class Bill {
    private int billNo;
    private String jobCardNo;
    private String supervisorName;
    private LocalDate billGeneratedDate;
    private String registrationNo;
    private double amount;

    public Bill(int billNo, String jobCardNo, String supervisorName, LocalDate billGeneratedDate, String registrationNo, double amount) {
        this.billNo = billNo;
        this.jobCardNo = jobCardNo;
        this.supervisorName = supervisorName;
        this.billGeneratedDate = billGeneratedDate;
        this.registrationNo = registrationNo;
        this.amount = amount;
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public String getJobCardNo() {
        return jobCardNo;
    }

    public void setJobCardNo(String jobCardNo) {
        this.jobCardNo = jobCardNo;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public LocalDate getBillGeneratedDate() {
        return billGeneratedDate;
    }

    public void setBillGeneratedDate(LocalDate billGeneratedDate) {
        this.billGeneratedDate = billGeneratedDate;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
