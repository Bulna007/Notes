package com.txmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.txmgmt.bo.CustomerBo;
import com.txmgmt.bo.SubscriberBo;
import com.txmgmt.dao.CustomerDao;
import com.txmgmt.dao.SubscriberDao;
import com.txmgmt.form.SubscriptionForm;

@Service
public class SubscriberService {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private SubscriberDao subscriberDao;

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int newSubscriber(SubscriptionForm form) {
		int customerNo = 0;
		int subscriberNo = 0;
		CustomerBo customerBo = null;
		SubscriberBo subscriberBo = null;

		customerBo = new CustomerBo();
		customerBo.setFullname(form.getFullname());
		customerBo.setDob(form.getDob());
		customerBo.setGender(form.getGender());
		customerBo.setMobileNo(form.getMobileNo());
		customerBo.setEmailAddress(form.getEmailAddress());

		customerNo = customerDao.saveCustomer(customerBo);
		subscriberBo = new SubscriberBo();
		subscriberBo.setSubscriptionType(form.getSubscriptionType());
		subscriberBo.setPlanName(form.getPlanName());
		subscriberBo.setCircle(form.getCircle());
		subscriberBo.setValidityDays(form.getValidityDays());
		subscriberBo.setBillAmount(form.getBillAmount());
		subscriberBo.setCustomerNo(customerNo);

		subscriberNo = subscriberDao.saveSubscriber(subscriberBo);

		return subscriberNo;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setSubscriberDao(SubscriberDao subscriberDao) {
		this.subscriberDao = subscriberDao;
	}

}
