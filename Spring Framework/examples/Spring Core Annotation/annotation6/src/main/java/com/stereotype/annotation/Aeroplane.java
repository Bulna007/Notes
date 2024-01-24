package com.stereotype.annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("boeing747")
//@Scope("prototype")
//@Service
//@Repository
@Lazy
public class Aeroplane {
	
	
	public Aeroplane() {
		System.out.println("Aeroplane()");
	}

	public void fly() {
		System.out.println("flying...");
	}
}
