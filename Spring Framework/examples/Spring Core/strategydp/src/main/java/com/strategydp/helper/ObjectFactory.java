package com.strategydp.helper;

import java.io.InputStream;
import java.util.Properties;

public class ObjectFactory {

	public static Object createObject(String lClassname) throws Exception {
		Properties props = null;
		InputStream in = null;
		Class<?> clazz = null;
		Object obj = null;
		String fqnClass;

		props = new Properties();
		in = ObjectFactory.class.getClassLoader().getResourceAsStream("com/strategydp/common/appClasses.properties");
		props.load(in);

		if (!props.containsKey(lClassname)) {
			throw new Exception("fqnClass is not found for given lclassname: " + lClassname);
		}
		fqnClass = props.getProperty(lClassname);
		clazz = Class.forName(fqnClass);

		obj = clazz.newInstance();

		return obj;
	}
}
