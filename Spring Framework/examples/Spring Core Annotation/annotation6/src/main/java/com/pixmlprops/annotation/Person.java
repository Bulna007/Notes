package com.pixmlprops.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// source code
@Component
public class Person {
	@Value("#{pixmlvalues.id}")
	private int id;
	@Value("#{pixmlvalues.fullname}")
	private String fullname;
	@Value("#{pixmlvalues.age}")
	private int age;
	@Value("#{pixmlvalues.gender}")
	private String gender;

	@Override
	public String toString() {
		return "Person [id=" + id + ", fullname=" + fullname + ", age=" + age + ", gender=" + gender + "]";
	}

}
