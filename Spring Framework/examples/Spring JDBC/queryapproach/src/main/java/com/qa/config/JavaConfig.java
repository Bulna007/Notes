package com.qa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { "com.qa.dao" })
public class JavaConfig {

	@Bean
	public DataSource dataSource(@Value("${db.driverClassname}") String driverClassname, @Value("${db.url}") String url,
			@Value("${db.username}") String username, @Value("${db.password}") String password) {
		DriverManagerDataSource dataSource = null;

		dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClassname);

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
