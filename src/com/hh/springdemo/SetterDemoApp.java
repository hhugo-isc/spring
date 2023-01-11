package com.hh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean from spring container
		Coach coach = context.getBean("myCricketCoach", Coach.class);

		// call methods on the bean
		// let's call our new method for fortunes
		System.out.println(coach.getDailyWorkout());

		System.out.println(coach.getDailyFortune());

		// close the context
		context.close();
	}

}
