package com.jihm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "payment")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "paymentType")
//@DiscriminatorValue("Cash")
//@Inheritance(strategy = InheritanceType.JOINED)
@TableGenerator(name = "paymentNoTableGen", table = "unique_keys", pkColumnName = "pkColumn", pkColumnValue = "paymentNo", valueColumnName = "pkValue", allocationSize = 1)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Payment implements Serializable {
    @Id
    @Column(name = "payment_no")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "paymentNoTableGen")
    protected int paymentNo;
    @Column(name = "payment_dt")
    protected LocalDate paymentDate;
    @Column(name = "customer_nm")
    protected String customerName;
    @Column(name = "bill_no")
    protected String billNo;
    @Column(name = "mobile_no")
    protected String mobileNo;
    protected double amount;

    public int getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(int paymentNo) {
        this.paymentNo = paymentNo;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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
        if (!(o instanceof Payment payment)) return false;
        return getPaymentNo() == payment.getPaymentNo() && Double.compare(payment.getAmount(), getAmount()) == 0 && Objects.equals(getPaymentDate(), payment.getPaymentDate()) && Objects.equals(getCustomerName(), payment.getCustomerName()) && Objects.equals(getBillNo(), payment.getBillNo()) && Objects.equals(getMobileNo(), payment.getMobileNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentNo(), getPaymentDate(), getCustomerName(), getBillNo(), getMobileNo(), getAmount());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentNo=" + paymentNo +
                ", paymentDate=" + paymentDate +
                ", customerName='" + customerName + '\'' +
                ", billNo='" + billNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", amount=" + amount +
                '}';
    }
}
