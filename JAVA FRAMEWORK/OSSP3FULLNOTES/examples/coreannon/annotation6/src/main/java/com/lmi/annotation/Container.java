package com.lmi.annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
abstract public class Container {

	public void receive(String data) {
		Worker worker = lookupWorker();
		worker.setData(data);
		worker.process();
	}

	@Lookup("worker")
	abstract public Worker lookupWorker();
}
