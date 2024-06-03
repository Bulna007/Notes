package com.jihm.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
//@DiscriminatorValue("Cheque")
@Table(name = "cheque_payment")
//@PrimaryKeyJoinColumn(name = "cheque_payment_no")
public class ChequePayment extends Payment {
    @Column(name = "cheque_no")
    private String chequeNo;
    @Column(name = "cheque_dt")
    private LocalDate chequeDate;
    @Column(name = "issuer_nm")
    private String issuerName;
    @Column(name = "bank_nm")
    private String bankName;

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public LocalDate getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(LocalDate chequeDate) {
        this.chequeDate = chequeDate;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChequePayment that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getChequeNo(), that.getChequeNo()) && Objects.equals(getChequeDate(), that.getChequeDate()) && Objects.equals(getIssuerName(), that.getIssuerName()) && Objects.equals(getBankName(), that.getBankName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getChequeNo(), getChequeDate(), getIssuerName(), getBankName());
    }

    @Override
    public String toString() {
        return "ChequePayment{" +
                "chequeNo='" + chequeNo + '\'' +
                ", chequeDate=" + chequeDate +
                ", issuerName='" + issuerName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", paymentNo=" + paymentNo +
                ", paymentDate=" + paymentDate +
                ", customerName='" + customerName + '\'' +
                ", billNo='" + billNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", amount=" + amount +
                "} " + super.toString();
    }
}
