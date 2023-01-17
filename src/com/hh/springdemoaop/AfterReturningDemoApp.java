package com.hh.springdemoaop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.springdemoaop.dao.AccountDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

//		call method to find the accounts
		List<Account> accounts = accountDao.findAccounts();

//		display the accounts
		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("\n");

//		close the context
		context.close();
	}

}
