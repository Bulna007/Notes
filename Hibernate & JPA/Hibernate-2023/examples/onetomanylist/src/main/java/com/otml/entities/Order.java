package com.otml.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Order implements Serializable {
    private int orderNo;
    private String customerName;
    private LocalDate orderedDate;
    private String mobileNo;
    private String emailAddress;
    private double amount;

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDate orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getCustomerName().equals(order.getCustomerName()) && getMobileNo().equals(order.getMobileNo()) && getEmailAddress().equals(order.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerName(), getMobileNo(), getEmailAddress());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", customerName='" + customerName + '\'' +
                ", orderedDate=" + orderedDate +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", amount=" + amount +
                '}';
    }
}
