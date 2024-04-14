package com.npjt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { "com.npjt.dao" })
public class JavaConfig {
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getProperty("db.url"),
				env.getProperty("db.username"), env.getProperty("db.password"));
		dataSource.setDriverClassName(env.getProperty("db.driverClassname"));

		return dataSource;
	}

	@Bean
	public NamedParameterJdbcTemplate npJdbcTemplate(DataSource dataSource) {
		NamedParameterJdbcTemplate npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		return npJdbcTemplate;
	}

}
