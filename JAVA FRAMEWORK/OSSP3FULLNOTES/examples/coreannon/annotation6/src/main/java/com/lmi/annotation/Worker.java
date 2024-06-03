package com.lmi.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Worker {
	private String data;

	public void setData(String data) {
		this.data = data;
	}

	public void process() {
		System.out.println("worker processing the request : " + data);
	}
}
