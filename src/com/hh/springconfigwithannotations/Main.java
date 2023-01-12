package com.hh.springconfigwithannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		get the bean from spring container 
		Coach coach = context.getBean("tennisCoach", Coach.class);
//		call a method on the bean
		System.out.println(coach.getDaylyWorkout());
//		call method to get daily fortune
		System.out.println(coach.getDailyFortune());
//		close the context
		context.close();
	}

}
