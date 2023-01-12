package com.hh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean from spring container
		CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);

		// call methods on the bean
		// let's call our new method for fortunes
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		// close the context
		context.close();
	}

}
