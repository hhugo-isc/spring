package com.hh.springconfigwithannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScope {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach coach2 = context.getBean("tennisCoach", Coach.class);

		boolean result = coach == coach2;

		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for coach: " + coach);
		System.out.println("\nMemory location for coach2: " + coach2);

		context.close();
	}

}
