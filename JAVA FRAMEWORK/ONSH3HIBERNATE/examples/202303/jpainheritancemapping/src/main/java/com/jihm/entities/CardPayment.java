package com.jihm.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
//@DiscriminatorValue("Card")
@Table(name = "card_payment")
//@PrimaryKeyJoinColumn(name = "card_payment_no")
public class CardPayment extends Payment {
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "last_4_digits")
    private String last4Digits;
    @Column(name = "bank_nm")
    private String bankName;
    @Column(name = "valid_thru")
    private String validThru;
    @Column(name = "card_holder_nm")
    private String cardHolderName;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getValidThru() {
        return validThru;
    }

    public void setValidThru(String validThru) {
        this.validThru = validThru;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPayment that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getCardType(), that.getCardType()) && Objects.equals(getLast4Digits(), that.getLast4Digits()) && Objects.equals(getBankName(), that.getBankName()) && Objects.equals(getValidThru(), that.getValidThru()) && Objects.equals(getCardHolderName(), that.getCardHolderName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCardType(), getLast4Digits(), getBankName(), getValidThru(), getCardHolderName());
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "cardType='" + cardType + '\'' +
                ", last4Digits='" + last4Digits + '\'' +
                ", bankName='" + bankName + '\'' +
                ", validThru='" + validThru + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", paymentNo=" + paymentNo +
                ", paymentDate=" + paymentDate +
                ", customerName='" + customerName + '\'' +
                ", billNo='" + billNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", amount=" + amount +
                "} " + super.toString();
    }
}
