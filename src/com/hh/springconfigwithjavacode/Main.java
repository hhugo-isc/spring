package com.hh.springconfigwithjavacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

//		Read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

//		get the bean from spring container
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

//		call a method on the bean
		System.out.println(coach.getDailyWorkout());

//		cal method to get the daily fortune
		System.out.println(coach.getDailyFortune());

//		call our new swim coach methods .. has the props values injectes
		System.out.println("email: " + coach.getEmail());
		System.out.println("team: " + coach.getTeam());

		context.close();

	}

}
