package com.stereotypepi.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// source code
@Component
@PropertySource("classpath:com/stereotypepi/annotation/stereotypepivalues.properties")
public class Address {
	@Value("${streetAddress}")
	private String streetAddress;
	@Value("${city}")
	private String city;
	@Value("${state}")
	private String state;
	@Value("${zip}")
	private int zip;
	@Value("${country}")
	private String country;

	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", country=" + country + "]";
	}

}
