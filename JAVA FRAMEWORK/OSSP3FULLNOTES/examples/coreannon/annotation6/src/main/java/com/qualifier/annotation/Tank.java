package com.qualifier.annotation;

public class Tank {
	int capacity;

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Tank [capacity=" + capacity + "]";
	}
	
	
}
