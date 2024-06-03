package com.dependson.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dependson.accessor.IAccessor;

public class CacheManager {
	private Cache cache;
	private List<IAccessor> accessors;

	public CacheManager(Cache cache, List<IAccessor> accessors) {
		this.cache = cache;
		this.accessors = accessors;

		initialize();
	}

	public void initialize() {
		Map<String, Object> dataMap = new HashMap<>();

		accessors.forEach(accessor -> {
			try {
				dataMap.put(accessor.getKey(), accessor.getData());
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("failed loading the data into cache", e);
			}
		});
		cache.load(dataMap);
	}

}
