package com.instancefactorymethod.beans;

public class TruckBuilder {
	private int truckNo;
	private String model;
	private String manufacturer;
	private int capacity;
	private int tires;
	private double price;

	public TruckBuilder(int truckNo) {
		this.truckNo = truckNo;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setTires(int tires) {
		this.tires = tires;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Truck build(String truckType) {
		Truck truck = null;

		if ("mini".equals(truckType)) {
			truck = new MiniTruckImpl();
		} else if ("tipper".equals(truckType)) {
			truck = new TipperTruckImpl();
		}

		truck.setTruckNo(truckNo);
		truck.setModel(model);
		truck.setManufacturer(manufacturer);
		truck.setCapacity(capacity);
		truck.setTires(tires);
		truck.setPrice(price);

		return truck;
	}

}
