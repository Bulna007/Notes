package com.instancefactorymethod.beans;

public class MiniTruckImpl extends Truck {
	
	public void drive(int loadNo) {
		System.out.println("Driving MiniTruck [truckNo=" + truckNo + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", capacity=" + capacity + ", tires=" + tires + ", price=" + price + "] for the loadNo : " + loadNo);
	}
}
