package com.autowire.annotation;

public class Equalizer {
	private String mode;

	public void equalize() {
		System.out.println("applying mode : " + mode);
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
