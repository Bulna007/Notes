package com.strategydp.beans;

import com.strategydp.converters.IMessageConverter;

public class MessageWriter {
	private IMessageConverter messageConverter;

	public void writeMessage(String message) {
		String cMessage = null;

		// messageConverter = MessageConverterFactory.createMessageConverter("pdf");
		cMessage = messageConverter.convert(message);
		System.out.println(cMessage);
	}

	public void setMessageConverter(IMessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}
}
