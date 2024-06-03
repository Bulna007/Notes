package com.sfm.beans;

import java.util.Calendar;

public class Appointment {
	private int appointmentNo;
	private String name;
	private Calendar createdDate;
	private String status;

	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentNo=" + appointmentNo + ", name=" + name + ", createdDate=" + createdDate
				+ ", status=" + status + "]";
	}

}
