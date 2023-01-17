package com.hh.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

//	this is where we add all of our related advices for logging

//	let's start with an @before advice
//	@Before("execution(public void updateAccount())")
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n----->>> Executing @Before advice on method");
	}

}
