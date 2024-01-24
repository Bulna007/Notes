package com.stereotypejavaconfig.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// source code
@Component
public class Robot {
	private Chip chip;

	@Autowired
	public void setChip(Chip chip) {
		this.chip = chip;
	}

	@Override
	public String toString() {
		return "Robot [chip=" + chip + "]";
	}

}
