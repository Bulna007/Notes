package com.oto.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "bill")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_no")
    private int billNo;
    @Column(name = "bill_generated_dt")
    private LocalDate billGeneratedDate;
    @Column(name = "customer_nm")
    private String customerName;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "due_dt")
    private LocalDate dueDate;
    @Column(name = "bill_amt")
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
