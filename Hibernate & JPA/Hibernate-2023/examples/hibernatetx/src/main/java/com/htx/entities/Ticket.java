package com.htx.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 4020990764056627059L;
	private int ticketNo;
	private String source;
	private String destination;
	private LocalDate journeyDate;
	private String passengerName;
	private String gender;
	private int age;

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
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

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, destination, gender, journeyDate, passengerName, source, ticketNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return age == other.age && Objects.equals(destination, other.destination)
				&& Objects.equals(gender, other.gender) && Objects.equals(journeyDate, other.journeyDate)
				&& Objects.equals(passengerName, other.passengerName) && Objects.equals(source, other.source)
				&& ticketNo == other.ticketNo;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", source=" + source + ", destination=" + destination + ", journeyDate="
				+ journeyDate + ", passengerName=" + passengerName + ", gender=" + gender + ", age=" + age + "]";
	}

}
