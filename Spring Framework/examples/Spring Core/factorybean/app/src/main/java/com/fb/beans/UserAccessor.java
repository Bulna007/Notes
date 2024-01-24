package com.fb.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class UserAccessor implements BeanFactoryAware {
	private BeanFactory beanFactory;

	public void showUsers() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = beanFactory.getBean("connection", Connection.class);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from users");
			while (rs.next()) {
				System.out.println(
						"user id: " + rs.getInt(1) + " username: " + rs.getString(2) + " password: " + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
