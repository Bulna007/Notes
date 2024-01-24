package com.aa.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	public int add(int a, int b) {
		System.out.println("in add()");
		return a + b;
	}
}
