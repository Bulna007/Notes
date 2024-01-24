package com.dependson.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	private static Cache instance;
	private Map<String, Object> dataMap;

	private Cache() {
		dataMap = new ConcurrentHashMap<>();
	}

	public void load(Map<String, Object> dataMap) {
		synchronized (this.dataMap) {
			this.dataMap.putAll(dataMap);
		}
	}

	public synchronized static Cache getInstance() {
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
