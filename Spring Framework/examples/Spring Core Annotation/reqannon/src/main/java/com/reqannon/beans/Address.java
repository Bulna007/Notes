package com.reqannon.beans;

public class Address {
	private String id;
	private String domain;

	public void setId(String id) {
		this.id = id;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return id + "@" + domain;
	}

}
