package com.hh.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

//	this is where we add all of our related advices for logging

//	let's start with an @before advice
//	@Before("execution(public void updateAccount())")
//	@Before("execution(public void add*())")
//	@Before("execution(* add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n----->>> Executing @Before advice on method");
//	}

//	@Before("execution(* add*(com.hh.springdemoaop.Account))")
//	public void beforeAddAccountAdviceWithAccountParam() {
//		System.out.println("\n----->>> Executing @Before advice on method");
//	}

//	@Before("execution(* add*(com.hh.springdemoaop.Account, ..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n----->>> Executing @Before advice on method");
//	}

//	@Before("execution(* add*(..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n----->>> Executing @Before advice on method");
//	}

//	@Before("execution(* com.hh.springdemoaop.dao.*.*(..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n----->>> Executing @Before advice on method");
//	}

//	@Pointcut("execution(* com.hh.springdemoaop.dao.*.*(..))")
//	public void forDaoPackage() {
//
//	}
//
//	@Before("forDaoPackage()")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n----->>> Executing @Before advice on method");
//	}
//
//	@Before("forDaoPackage()")
//	public void performApiAnalytics() {
//		System.out.println("\n----->>> Performing API Analytics");
//	}

//	@Pointcut("execution(* com.hh.springdemoaop.dao.*.*(..))")
//	public void forDaoPackage() {
//	}
//
//	@Pointcut("execution(* com.hh.springdemoaop.dao.*.get*(..))")
//	public void getter() {
//	}
//
//	@Pointcut("execution(* com.hh.springdemoaop.dao.*.set*(..))")
//	public void setter() {
//	}
//
//	@Pointcut("forDaoPackage() && !(getter() || setter())")
//	public void forDaoPackageAndExludeGetterAndSetter() {
//	}

	@Before("com.hh.springdemoaop.aspect.LuvAopExpressions.forDaoPackageAndExludeGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n----->>> Executing @Before advice on method");
	}

}
