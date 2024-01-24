package com.aroundadvice.beans;

public class Calculator {
	public int add(int a, int b) {
		int sum = 0;
		sum = a + b;
		System.out.println("in add()");
		return sum;
	}

	public int substract(int a, int b) {
		System.out.println("in substract()");
		return b - a;
	}

	public int multiply(int a, int b) {
		System.out.println("in multiply()");
		return a * b;
	}
}
