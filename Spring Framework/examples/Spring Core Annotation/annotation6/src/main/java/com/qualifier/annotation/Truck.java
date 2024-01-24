package com.qualifier.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Truck {
	private Tank tank;

	@Autowired
	@Qualifier("dieselTank")
	public void setTank(Tank tank) {
		this.tank = tank;
	}

	@Override
	public String toString() {
		return "Truck [tank=" + tank + "]";
	}

}
