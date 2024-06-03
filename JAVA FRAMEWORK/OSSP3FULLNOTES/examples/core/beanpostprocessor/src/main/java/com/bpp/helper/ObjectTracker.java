package com.bpp.helper;

import java.util.concurrent.atomic.AtomicInteger;

public class ObjectTracker {
	private static AtomicInteger nobjects = new AtomicInteger(0);

	public static void increment() {
		nobjects.incrementAndGet();
	}

	public static int get() {
		return nobjects.get();
	}

}
