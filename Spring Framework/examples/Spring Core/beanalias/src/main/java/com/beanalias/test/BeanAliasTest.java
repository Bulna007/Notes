package com.beanalias.test;

import java.util.stream.Stream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.beanalias.beans.Person;

public class BeanAliasTest {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("com/beanalias/common/application-context.xml"));
		Person person = beanFactory.getBean("person2", Person.class);
		System.out.println(person);

		Stream.of(beanFactory.getAliases("person")).forEach(System.out::println);
	}

}
