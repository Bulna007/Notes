package com.cch.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "EnrollmentForm")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "enrollmentForm")
public class EnrollmentForm {
    private String fullname;
    //@JsonbDateFormat("dd/MM/yyyy")
    //@JsonFormat(pattern = "dd/MM/yyyy")
    //private LocalDate dob;
    private String gender;
    private String mobileNo;
    private String emailAddress;
    private String planNo;
    private String planName;
    private int tenure;
    private double insurredAmount;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getInsurredAmount() {
        return insurredAmount;
    }

    public void setInsurredAmount(double insurredAmount) {
        this.insurredAmount = insurredAmount;
    }

    @Override
    public String toString() {
        return "EnrollmentForm{" +
                "fullname='" + fullname + '\'' +
                //", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", planNo='" + planNo + '\'' +
                ", planName='" + planName + '\'' +
                ", tenure=" + tenure +
                ", insurredAmount=" + insurredAmount +
                '}';
    }
}
