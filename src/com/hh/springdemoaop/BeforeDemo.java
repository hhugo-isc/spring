package com.hh.springdemoaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.springdemoaop.dao.AccountDao;
import com.hh.springdemoaop.dao.MembershipDAO;

public class BeforeDemo {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

//		get membership bean from spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");
		accountDao.addAccount(account, true);
		accountDao.doWork();

//		call the accountdao getter/setter methods
		accountDao.setName("foobar");
		accountDao.setServiceCode("silver");

		String name = accountDao.getName();
		String code = accountDao.getServiceCode();

//		call the membership method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();

//		close the context
		context.close();
	}

}
