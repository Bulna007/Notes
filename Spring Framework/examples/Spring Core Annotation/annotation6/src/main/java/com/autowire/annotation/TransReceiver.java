package com.autowire.annotation;

public class TransReceiver {
	private int frequency;

	public void tune() {
		System.out.println("tuning to frequency : " + frequency);
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
