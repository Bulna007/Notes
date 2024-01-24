package com.instancefactorymethod.beans;

import java.security.SecureRandom;

public class CargoManager {
	private Truck truck;

	public int scheduleTruck(int loadNo) {
		truck.drive(loadNo);
		System.out.println("scheduled the truck : " + truck.getTruckNo() + " for load : " + loadNo);
		return new SecureRandom().nextInt();
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

}
