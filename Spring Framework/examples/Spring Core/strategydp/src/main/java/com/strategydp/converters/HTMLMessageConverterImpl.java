package com.strategydp.converters;

final public class HTMLMessageConverterImpl implements IMessageConverter {

	@Override
	public String convert(String message) {
		return "<html><body>" + message + "</body></html>";
	}

}
