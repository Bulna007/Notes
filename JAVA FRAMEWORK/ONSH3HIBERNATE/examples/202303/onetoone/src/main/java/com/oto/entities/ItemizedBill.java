package com.oto.entities;

import java.io.Serializable;
import java.util.Objects;

public class ItemizedBill implements Serializable {
    private int billNo;
    private long localMessages;
    private long internationalMessages;
    private long localVoiceMinutes;
    private long internationalVoiceMinutes;
    private double previousDueAmount;
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
