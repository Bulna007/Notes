package com.stereotypejavaconfig.annotation;


// no source code
public class Chip {
	private String chipType;

	public void setChipType(String chipType) {
		this.chipType = chipType;
	}

	@Override
	public String toString() {
		return "Chip [chipType=" + chipType + "]";
	}

}
