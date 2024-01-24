package com.si.beans;

public class Remote {
	private Television television;

	public void poweron() {
		television.on();
	}

	public void setTelevision(Television television) {
		System.out.println("setTelevision(Television television)");
		this.television = television;
	}

	// alt + shift + s
	// press r
	// alt + l (setter)
	// alt + r
}
