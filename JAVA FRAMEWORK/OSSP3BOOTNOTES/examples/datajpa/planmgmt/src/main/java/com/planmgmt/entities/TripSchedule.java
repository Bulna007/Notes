package com.planmgmt.entities;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface TripSchedule {
    @Value("#{target.tripNo}")
    int getTourNo();

    @Value("#{target.tripName}")
    String getTourName();

    @Value("#{target.startDate}")
    LocalDate getPlannedStartDate();

    @Value("#{target.endDate}")
    LocalDate getApproximateEndDate();
}
