package com.planmgmt.entities;

public class TripDetails {
    private int tripNo;
    private String tripName;
    private int days;

    public TripDetails(int tripNo, String tripName, int days) {
        this.tripNo = tripNo;
        this.tripName = tripName;
        this.days = days;
    }

    public int getTripNo() {
        return tripNo;
    }

    public String getTripName() {
        return tripName;
    }

    public int getDays() {
        return days;
    }
}
