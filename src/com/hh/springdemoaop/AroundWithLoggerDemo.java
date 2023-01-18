package com.hh.springdemoaop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.springdemoaop.service.TrafficFortuneService;

public class AroundWithLoggerDemo {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemo.class.getName());

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		String data = trafficFortuneService.getFortune();

		myLogger.info("\nMy fortune is: " + data);
		myLogger.info("Finished");

//		close the context
		context.close();
	}
}
