package com.aroundadvice.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	private Map<String, Object> dataMap;
	private static Cache instance;

	private Cache() {
		dataMap = new ConcurrentHashMap<>();
	}

	public static synchronized Cache getInstance() {
		if (instance == null) {
			instance = new Cache();
		}
		return instance;
	}

	public void put(String key, Object val) {
		dataMap.put(key, val);
	}

	public Object get(String key) {
		return dataMap.get(key);
	}

	public boolean containsKey(String key) {
		return dataMap.containsKey(key);
	}

}
