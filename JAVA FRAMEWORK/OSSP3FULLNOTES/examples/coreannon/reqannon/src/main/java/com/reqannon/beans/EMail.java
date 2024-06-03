package com.reqannon.beans;

import org.springframework.beans.factory.annotation.Required;

public class EMail {
	private String subject;
	private String body;
	private Address from;
	private Address to;

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Required
	public void setBody(String body) {
		this.body = body;
	}

	@Required
	public void setFrom(Address from) {
		this.from = from;
	}

	@Required
	public void setTo(Address to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "EMail [subject=" + subject + ", body=" + body + ", from=" + from + ", to=" + to + "]";
	}

}
