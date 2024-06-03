package com.javaconfigstereotype.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// source code
@Component
public class Rocket {
	@Value("${rocketType}")
	private String rocketType;

	@Override
	public String toString() {
		return "Rocket [rocketType=" + rocketType + "]";
	}

}
