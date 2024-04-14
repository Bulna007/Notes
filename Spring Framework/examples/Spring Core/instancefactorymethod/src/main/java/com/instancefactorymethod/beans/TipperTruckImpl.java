package com.instancefactorymethod.beans;

public class TipperTruckImpl extends Truck {
	
	public void drive(int loadNo) {
		System.out.println("Driving Tipper Truck [truckNo=" + truckNo + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", capacity=" + capacity + ", tires=" + tires + ", price=" + price + "] for the loadNo : " + loadNo);
	}
}
