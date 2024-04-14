package com.txmgmt.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.txmgmt.controller.NewSubscriberController;
import com.txmgmt.form.SubscriptionForm;

public class TxMgmtTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/txmgmt/common/application-context.xml");
		SubscriptionForm form = new SubscriptionForm();
		form.setFullname("Alex");
		form.setDob(new Date());
		form.setGender("Male");
		form.setMobileNo("93847940");
		form.setEmailAddress("alex@gmail.com");

		form.setSubscriptionType("postpaid");
		form.setPlanName("UL299");
		form.setValidityDays(30);
		form.setCircle("APR");
		form.setBillAmount(2300);

		NewSubscriberController controller = context.getBean("newSubscriberController", NewSubscriberController.class);
		int subscriberNo = controller.addSubscriber(form);
		System.out.println("subscriber no : " + subscriberNo);

	}
}
