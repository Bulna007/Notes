package com.bs3.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Trip implements Serializable {
	private int tripNo;
	private String source;
	private String destination;
	private String tripName;
	private int days;
	private LocalDate startDate;
	private LocalDate endDate;
	private double tripCost;

	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getTripCost() {
		return tripCost;
	}

	public void setTripCost(double tripCost) {
		this.tripCost = tripCost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(days, destination, endDate, source, startDate, tripCost, tripName, tripNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		return days == other.days && Objects.equals(destination, other.destination)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(source, other.source)
				&& Objects.equals(startDate, other.startDate)
				&& Double.doubleToLongBits(tripCost) == Double.doubleToLongBits(other.tripCost)
				&& Objects.equals(tripName, other.tripName) && tripNo == other.tripNo;
	}

	@Override
	public String toString() {
		return "Trip [tripNo=" + tripNo + ", source=" + source + ", destination=" + destination + ", tripName="
				+ tripName + ", days=" + days + ", startDate=" + startDate + ", endDate=" + endDate + ", tripCost="
				+ tripCost + "]";
	}

}
