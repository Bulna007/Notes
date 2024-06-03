package com.txmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.txmgmt.form.SubscriptionForm;
import com.txmgmt.service.SubscriberService;

@Component
public class NewSubscriberController {
	@Autowired
	private SubscriberService subscriberService;

	public int addSubscriber(SubscriptionForm form) {
		int subscriberNo = 0;

		subscriberNo = subscriberService.newSubscriber(form);

		return subscriberNo;
	}

	public void setSubscriberService(SubscriberService subscriberService) {
		this.subscriberService = subscriberService;
	}

}
