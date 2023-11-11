package com.otmm.entities;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class Vendor {
    private int vendorNo;
    private String vendorName;
    private LocalDate establishedDate;
    private String contactNo;
    private String emailAddress;
    private Map<String, Project> allottedProjects;

    public int getVendorNo() {
        return vendorNo;
    }

    public void setVendorNo(int vendorNo) {
        this.vendorNo = vendorNo;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Map<String, Project> getAllottedProjects() {
        return allottedProjects;
    }

    public void setAllottedProjects(Map<String, Project> allottedProjects) {
        this.allottedProjects = allottedProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendor vendor)) return false;
        return getVendorName().equals(vendor.getVendorName()) && getContactNo().equals(vendor.getContactNo()) && getEmailAddress().equals(vendor.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVendorName(), getContactNo(), getEmailAddress());
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorNo=" + vendorNo +
                ", vendorName='" + vendorName + '\'' +
                ", establishedDate=" + establishedDate +
                ", contactNo='" + contactNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", allottedProjects=" + allottedProjects +
                '}';
    }
}
