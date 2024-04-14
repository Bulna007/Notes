package com.primary.annotation;

public class Wheel {
	private int radius;

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Wheel [radius=" + radius + "]";
	}

}
