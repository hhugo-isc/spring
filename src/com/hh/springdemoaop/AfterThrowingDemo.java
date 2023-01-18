package com.hh.springdemoaop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.springdemoaop.dao.AccountDao;

public class AfterThrowingDemo {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

//		call method to find the accounts
		List<Account> accounts = null;

		try {
//			add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

//		display the accounts
		System.out.println("\n\nMain program: AfterThrowingDemoApp");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("\n");

//		close the context
		context.close();
	}

}
