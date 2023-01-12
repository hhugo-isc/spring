package com.hh.springbeansscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanLifeCycle-applicationContext.xml");

		// Retrieve bean from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		// Coach coach2 = context.getBean("myCoach", Coach.class);

		// check if they are the same
		// boolean result = (coach == coach2);

		// prints out the result
		// System.out.println("\nPointing to the sabe object " + result);
		//
		// System.out.println("\nMemory location for coach: " + coach);
		// System.out.println("\nMemory location for coach2: " + coach2);

		System.out.println(coach.getDailyWorkout());

		// close the context
		context.close();

	}

}
