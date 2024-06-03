package com.javaconfigpi.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:com/javaconfigpi/annotation/javaconfigpivalues.properties")
public class JavaConfigPI {
//	@Autowired
//	private Environment env;

//	@Bean
//	public Passport passport() {
//		Passport passport = new Passport();
//		passport.setPassportNo(Integer.parseInt(env.getProperty("passportNo")));
//		passport.setPassportHolderName(env.getProperty("passportHolderName"));
//		passport.setAge(Integer.parseInt(env.getProperty("age")));
//		passport.setGender(env.getProperty("gender"));
//		
//		return passport;
//	}

	@Bean
	@Lazy
	public Passport passport(@Value("${passportNo}") int passportNo,
			@Value("${passportHolderName}") String passportHolderName, @Value("${age}") int age,
			@Value("${gender}") String gender) {
		System.out.println("passport()");
		Passport passport = new Passport();
		passport.setPassportHolderName(passportHolderName);
		passport.setPassportNo(passportNo);
		passport.setAge(age);
		passport.setGender(gender);

		return passport;
	}
}
