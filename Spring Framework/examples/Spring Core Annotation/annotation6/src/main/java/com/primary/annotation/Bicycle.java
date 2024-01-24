package com.primary.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bicycle {
	@Autowired
	private Wheel wheel;

	@Override
	public String toString() {
		return "Bicycle [wheel=" + wheel + "]";
	}

}
