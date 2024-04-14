package com.nbf.beans;

import java.util.Date;

public class Appointment {
	private int appointmentNo;
	private Date appointmentDate;
	private String patientName;
	private Doctor doctor;

	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentNo=" + appointmentNo + ", appointmentDate=" + appointmentDate + ", patientName="
				+ patientName + ", doctor=" + doctor + "]";
	}

}
