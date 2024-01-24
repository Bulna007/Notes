package com.beanalias.beans;

public class Person {
	private int uniqueNo;
	private String fullname;
	private int age;
	private String gender;

	public Person(int uniqueNo, String fullname, int age, String gender) {
		this.uniqueNo = uniqueNo;
		this.fullname = fullname;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [uniqueNo=" + uniqueNo + ", fullname=" + fullname + ", age=" + age + ", gender=" + gender + "]";
	}

}
