package com.ch.dto;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDate;

public class RoomBookingRequestDto {
    private String fullname;
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate dob;
    private String gender;
    private String mobileNo;
    private String emailAddress;
    private String roomType;
    private String identityProof;
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate bookingDate;
    private int days;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getIdentityProof() {
        return identityProof;
    }

    public void setIdentityProof(String identityProof) {
        this.identityProof = identityProof;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
