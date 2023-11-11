package com.gl.entities;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable, IPassenger {
	private static final long serialVersionUID = 8541060554056230483L;
	private int passengerNo;
	private String passengerName;
	private int age;
	private String gender;

	public int getPassengerNo() {
		return passengerNo;
	}

	public void setPassengerNo(int passengerNo) {
		this.passengerNo = passengerNo;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, gender, passengerName, passengerNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return age == other.age && Objects.equals(gender, other.gender)
				&& Objects.equals(passengerName, other.passengerName) && passengerNo == other.passengerNo;
	}

	@Override
	public String toString() {
		return "Passenger [passengerNo=" + passengerNo + ", passengerName=" + passengerName + ", age=" + age
				+ ", gender=" + gender + "]";
	}

}
