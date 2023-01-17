package com.hh.springdemoaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.springdemoaop.aop.AccountDao;

public class Main {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

//		call the business method
		accountDao.addAccount();

//		let's do it again
		System.out.println("\n Let's do it again\n");

		// call the business method again
		accountDao.addAccount();
//		close the context
		context.close();
	}

}
