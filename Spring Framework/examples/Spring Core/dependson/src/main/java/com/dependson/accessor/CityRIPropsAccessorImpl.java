package com.dependson.accessor;

import java.util.Properties;

public class CityRIPropsAccessorImpl implements IAccessor {
	private String key;

	public CityRIPropsAccessorImpl(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public Object getData() throws Exception {
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("cityri.properties"));
		return props;
	}	
}
