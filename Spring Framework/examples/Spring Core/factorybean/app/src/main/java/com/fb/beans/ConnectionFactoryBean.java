package com.fb.beans;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.FactoryBean;

public class ConnectionFactoryBean implements FactoryBean<Connection> {
	private String driverClassname;
	private String url;
	private String username;
	private String password;

	public ConnectionFactoryBean(String driverClassname, String url, String username, String password) {
		this.driverClassname = driverClassname;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getObject() throws Exception {
		Class.forName(driverClassname);
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

	@Override
	public Class<?> getObjectType() {
		return Connection.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
