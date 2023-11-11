package com.oto.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Bill implements Serializable {
    private int billNo;
    private LocalDate billGeneratedDate;
    private String customerName;
    private String mobileNo;
    private LocalDate dueDate;
    private double billAmount;

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public LocalDate getBillGeneratedDate() {
        return billGeneratedDate;
    }

    public void setBillGeneratedDate(LocalDate billGeneratedDate) {
        this.billGeneratedDate = billGeneratedDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill bill)) return false;
        return getCustomerName().equals(bill.getCustomerName()) && getMobileNo().equals(bill.getMobileNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerName(), getMobileNo());
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billNo=" + billNo +
                ", billGeneratedDate=" + billGeneratedDate +
                ", customerName='" + customerName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", dueDate=" + dueDate +
                ", billAmount=" + billAmount +
                '}';
    }
}
