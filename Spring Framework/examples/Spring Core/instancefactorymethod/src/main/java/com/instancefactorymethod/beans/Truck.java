package com.instancefactorymethod.beans;

public abstract class Truck {
	protected int truckNo;
	protected String model;
	protected String manufacturer;
	protected int capacity;
	protected int tires;
	protected double price;

	abstract void drive(int loadNo);

	public int getTruckNo() {
		return truckNo;
	}

	public void setTruckNo(int truckNo) {
		this.truckNo = truckNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getTires() {
		return tires;
	}

	public void setTires(int tires) {
		this.tires = tires;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
