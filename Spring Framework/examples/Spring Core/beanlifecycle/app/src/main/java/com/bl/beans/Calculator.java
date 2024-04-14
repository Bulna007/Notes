package com.bl.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Calculator implements InitializingBean, DisposableBean {
	private int i;
	private int j;
	private int sum;

	public Calculator(int i) {
		System.out.println("Calculator(int i)");
		this.i = i;
	}

	public void setJ(int j) {
		System.out.println("setJ(int j)");
		this.j = j;
	}

//	public void init() {
//		System.out.println("init()");
//		this.sum = this.i + this.j;
//	}
//
//	public void destroy() {
//		System.out.println("destroy()");
//		i = 0;
//		j = 0;
//		sum = 0;
//	}

	@Override
	public String toString() {
		return "Calculator [i=" + i + ", j=" + j + ", sum=" + sum + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		this.sum = this.i + this.j;
	}

	@Override
	public void destroy() throws Exception {
		this.i = 0;
		this.j = 0;
		this.sum = 0;
		System.out.println("destroy()");
	}

}
