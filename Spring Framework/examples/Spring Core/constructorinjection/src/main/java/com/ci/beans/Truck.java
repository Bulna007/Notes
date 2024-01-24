package com.ci.beans;

public class Truck {
	private Engine engine;

	public Truck(Engine engine) {
		this.engine = engine;
	}

	public void drive() {
		engine.on();
		System.out.println("driving the Truck.....");
	}
}
