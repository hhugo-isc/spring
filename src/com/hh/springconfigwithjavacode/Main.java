package com.hh.springconfigwithjavacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

//		Read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

//		get the bean from spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);

//		call a method on the bean
		System.out.println(coach.getDailyWorkout());

//		cal method to get the daily fortune
		System.out.println(coach.getDailyFortune());

		context.close();
	}

}
