package com.hh.springdemoaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.springdemoaop.dao.AccountDao;
import com.hh.springdemoaop.dao.MembershipDAO;

public class Main {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

//		get membership bean from spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account account = new Account();
		accountDao.addAccount(account);

//		call the membership method
		membershipDAO.addSillyMember();

//		close the context
		context.close();
	}

}
