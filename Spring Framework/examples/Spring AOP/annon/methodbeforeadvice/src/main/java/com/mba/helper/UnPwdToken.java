package com.mba.helper;

public class UnPwdToken {
	private String un;
	private String password;

	public UnPwdToken(String un, String password) {
		this.un = un;
		this.password = password;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
