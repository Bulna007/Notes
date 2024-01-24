package com.ci.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ci.beans.Game;
import com.ci.beans.Stadium;

public class CITest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/ci/common/application-context.xml"));
//		Game game = beanFactory.getBean("game1", Game.class);
//		System.out.println(game);
		Stadium stadium = beanFactory.getBean("wankhedeStadium", Stadium.class);
		System.out.println(stadium);
	}
}
