package com.hh.springdemoaop.dao;

import org.springframework.stereotype.Component;

import com.hh.springdemoaop.Account;

@Component
public class AccountDao {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCONT");
	}

}
