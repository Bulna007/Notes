package com.oto.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.ForeignGenerator;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "itemized_bill")
@GenericGenerator(name = "foreigngen", type = ForeignGenerator.class,
        parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "bill")})
public class ItemizedBill implements Serializable {
    @Id
    @Column(name = "bill_no")
    @GeneratedValue(generator = "foreigngen")
    private int billNo;
    @Column(name = "local_messages")
    private long localMessages;
    @Column(name = "international_messages")
    private long internationalMessages;
    @Column(name = "local_voice_mins")
    private long localVoiceMinutes;
    @Column(name = "international_voice_mins")
    private long internationalVoiceMinutes;
    @Column(name = "previous_due_amt")
    private double previousDueAmount;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Bill bill;

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public long getLocalMessages() {
        return localMessages;
    }

    public void setLocalMessages(long localMessages) {
        this.localMessages = localMessages;
    }

    public long getInternationalMessages() {
        return internationalMessages;
    }

    public void setInternationalMessages(long internationalMessages) {
        this.internationalMessages = internationalMessages;
    }

    public long getLocalVoiceMinutes() {
        return localVoiceMinutes;
    }

    public void setLocalVoiceMinutes(long localVoiceMinutes) {
        this.localVoiceMinutes = localVoiceMinutes;
    }

    public long getInternationalVoiceMinutes() {
        return internationalVoiceMinutes;
    }

    public void setInternationalVoiceMinutes(long internationalVoiceMinutes) {
        this.internationalVoiceMinutes = internationalVoiceMinutes;
    }

    public double getPreviousDueAmount() {
        return previousDueAmount;
    }

    public void setPreviousDueAmount(double previousDueAmount) {
        this.previousDueAmount = previousDueAmount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemizedBill that)) return false;
        return getLocalMessages() == that.getLocalMessages() && getInternationalMessages() == that.getInternationalMessages() && getLocalVoiceMinutes() == that.getLocalVoiceMinutes() && getInternationalVoiceMinutes() == that.getInternationalVoiceMinutes() && Double.compare(that.getPreviousDueAmount(), getPreviousDueAmount()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocalMessages(), getInternationalMessages(), getLocalVoiceMinutes(), getInternationalVoiceMinutes(), getPreviousDueAmount());
    }

    @Override
    public String toString() {
        return "ItemizedBill{" +
                "billNo=" + billNo +
                ", localMessages=" + localMessages +
                ", internationalMessages=" + internationalMessages +
                ", localVoiceMinutes=" + localVoiceMinutes +
                ", internationalVoiceMinutes=" + internationalVoiceMinutes +
                ", previousDueAmount=" + previousDueAmount +
                ", bill=" + bill +
                '}';
    }
}
