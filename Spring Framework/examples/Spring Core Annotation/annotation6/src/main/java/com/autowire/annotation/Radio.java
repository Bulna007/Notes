package com.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Radio {
	// @Autowired
	private TransReceiver transReceiver;
	// @Autowired
	private Equalizer equalizer;

//	@Autowired
//	public void newRadio(TransReceiver transReceiver, Equalizer equalizer) {
//		System.out.println("newRadio(...)");
//		this.transReceiver = transReceiver;
//		this.equalizer = equalizer;
//	}

	@Autowired(required = false)
	public Radio(TransReceiver transReceiver) {
		this.transReceiver = transReceiver;
	}

	@Autowired(required = false)
	public Radio(TransReceiver transReceiver, Equalizer equalizer) {
		this.transReceiver = transReceiver;
		this.equalizer = equalizer;
	}

	public void listen() {
		if (transReceiver != null) {
			transReceiver.tune();
		}
		if (equalizer != null) {
			equalizer.equalize();
		}

		System.out.println("listening...");
	}

//	@Autowired(required = false)
//	public void setTransReceiver(TransReceiver transReceiver) {
//		this.transReceiver = transReceiver;
//	}

}
