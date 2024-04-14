package com.strategydp.test;

import com.strategydp.beans.MessageWriter;
import com.strategydp.converters.IMessageConverter;
import com.strategydp.helper.ObjectFactory;

public class StrategyDPTest {
	public static void main(String[] args) throws Exception {
		MessageWriter messageWriter = (MessageWriter) ObjectFactory.createObject("messageWriter.class");
		IMessageConverter messageConverter = (IMessageConverter) ObjectFactory.createObject("messageConverter.class");
		messageWriter.setMessageConverter(messageConverter);

		messageWriter.writeMessage("Welcome to Strategy Design Pattern");
	}
}
