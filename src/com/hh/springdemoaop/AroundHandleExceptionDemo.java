package com.hh.springdemoaop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.springdemoaop.service.TrafficFortuneService;

public class AroundHandleExceptionDemo {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemo.class.getName());

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		myLogger.info("\nMy fortune is: " + data);
		myLogger.info("Finished");

//		close the context
		context.close();
	}
}
