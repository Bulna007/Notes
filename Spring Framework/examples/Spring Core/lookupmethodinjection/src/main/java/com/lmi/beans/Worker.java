package com.lmi.beans;

public class Worker {
	private String data;

	public void processRequest() {
		System.out.println("processing data : " + data);
	}

	public void setData(String data) {
		this.data = data;
	}
}
