package com.pcnamespace.beans;

public class Contract {
	private int duration;
	private int slaInDays;
	private String qos;

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setSlaInDays(int slaInDays) {
		this.slaInDays = slaInDays;
	}

	public void setQos(String qos) {
		this.qos = qos;
	}

	@Override
	public String toString() {
		return "Contract [duration=" + duration + ", slaInDays=" + slaInDays + ", qos=" + qos + "]";
	}

}
