package com.txmgmt.controller;

import com.txmgmt.form.SubscriptionForm;
import com.txmgmt.service.SubscriberService;

public class NewSubscriberController {
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
