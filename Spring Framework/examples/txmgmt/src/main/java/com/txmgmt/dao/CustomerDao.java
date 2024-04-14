package com.txmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.txmgmt.bo.CustomerBo;

public class CustomerDao {
	private final String SQL_INS_CUSTOMER = "insert into customer(fullname, dob, gender, mobile_no, email_address) values(?,?,?,?,?)";
	private JdbcTemplate jdbcTemplate;

	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveCustomer(CustomerBo bo) {
		int customerNo = 0;
		KeyHolder kh = null;

		kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SQL_INS_CUSTOMER, new String[] { "customer_no" });
				pstmt.setString(1, bo.getFullname());
				pstmt.setDate(2, new java.sql.Date(bo.getDob().getTime()));
				pstmt.setString(3, bo.getGender());
				pstmt.setString(4, bo.getMobileNo());
				pstmt.setString(5, bo.getEmailAddress());

				return pstmt;
			}
		}, kh);
		customerNo = kh.getKey().intValue();

		return customerNo;
	}

}
