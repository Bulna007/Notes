package com.otmasoto.entities;

import java.io.Serializable;
import java.util.Objects;

public class Locker implements Serializable {
    private int lockerNo;
    private String dimensions;
    private String branchCode;
    private int keyNo;
    private String termsAndConditions;
    private double charges;
    private Account account;

    public int getLockerNo() {
        return lockerNo;
    }

    public void setLockerNo(int lockerNo) {
        this.lockerNo = lockerNo;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public int getKeyNo() {
        return keyNo;
    }

    public void setKeyNo(int keyNo) {
        this.keyNo = keyNo;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locker locker)) return false;
        return getKeyNo() == locker.getKeyNo() && getBranchCode().equals(locker.getBranchCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBranchCode(), getKeyNo());
    }

    @Override
    public String toString() {
        return "Locker{" +
                "lockerNo=" + lockerNo +
                ", dimensions='" + dimensions + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", keyNo=" + keyNo +
                ", termsAndConditions='" + termsAndConditions + '\'' +
                ", charges=" + charges +
                ", account=" + account +
                '}';
    }
}
