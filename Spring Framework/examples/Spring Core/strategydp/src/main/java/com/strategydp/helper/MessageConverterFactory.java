package com.strategydp.helper;

import com.strategydp.converters.HTMLMessageConverterImpl;
import com.strategydp.converters.IMessageConverter;
import com.strategydp.converters.PDFMessageConverterImpl;

public class MessageConverterFactory {
	public static IMessageConverter createMessageConverter(String converterType) {
		IMessageConverter messageConverter = null;

		if (converterType.equals("html")) {
			messageConverter = new HTMLMessageConverterImpl();
		} else if (converterType.equals("pdf")) {
			messageConverter = new PDFMessageConverterImpl();
		}
		return messageConverter;
	}
}
