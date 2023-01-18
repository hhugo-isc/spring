package com.hh.springdemoaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.springdemoaop.service.TrafficFortuneService;

public class AroundDemo {
	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");
		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");

//		close the context
		context.close();
	}
}
