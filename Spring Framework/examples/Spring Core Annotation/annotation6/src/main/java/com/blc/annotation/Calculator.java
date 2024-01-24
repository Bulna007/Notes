package com.blc.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
public class Calculator {
	private int a;
	@Value("${b}")
	private int b;
	private int sum;

	public Calculator(@Value("${a}") int a) {
		this.a = a;
	}

	@PostConstruct
	public void init() {
		this.sum = this.a + this.b;
		System.out.println("initialized!");
	}

	@PreDestroy
	public void destroy() {
		this.sum = 0;
		System.out.println("destroyed!");
	}

	@Override
	public String toString() {
		return "Calculator [a=" + a + ", b=" + b + ", sum=" + sum + "]";
	}

}
