package com.txmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.txmgmt.bo.SubscriberBo;

@Repository
public class SubscriberDao {
	private final String SQL_INS_SUBSCRIBER = "insert into subscriber(subscription_type, plan_nm, circle, validity_days, bill_amt, customer_no) values(?,?,?,?,?,?)";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SubscriberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveSubscriber(SubscriberBo bo) {
		int subscriberNo = 0;
		KeyHolder kh = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SQL_INS_SUBSCRIBER, new String[] { "subscriber_no" });
				pstmt.setString(1, bo.getSubscriptionType());
				pstmt.setString(2, bo.getPlanName());
				pstmt.setString(3, bo.getCircle());
				pstmt.setInt(4, bo.getValidityDays());
				pstmt.setDouble(5, bo.getBillAmount());
				pstmt.setInt(6, bo.getCustomerNo());

				return pstmt;
			}
		}, kh);

		subscriberNo = kh.getKey().intValue();
		return subscriberNo;
	}

}
