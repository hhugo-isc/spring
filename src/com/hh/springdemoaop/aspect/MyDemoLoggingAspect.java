package com.hh.springdemoaop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hh.springdemoaop.Account;

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

//	@Before("com.hh.springdemoaop.aspect.LuvAopExpressions.forDaoPackageAndExludeGetterAndSetter()")
//	public void beforeAddAccountAdvice(JoinPoint joinpoint) {
//		System.out.println("\n----->>> Executing @Before advice on method");
//
////		display the method signature
//		MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
//		System.out.println("Method Signature: " + methodSignature.toString());
//
////		display method arguments
////		get args
//		Object[] args = joinpoint.getArgs();
////		loop thru args
//		for (Object arg : args) {
//			System.out.println("Arg: " + arg);
//			if (arg instanceof Account) {
//				Account account = (Account) arg;
//				System.out.println("Account name: " + account.getName());
//				System.out.println("Account level: " + account.getLevel());
//			}
//		}
//	}

//	add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.hh.springdemoaop.dao.AccountDao.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
//		print out what method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=========>>> Executing @AfterReturning on method: " + method);
//		print out the results of the method call
		System.out.println("\n=========>>> result is: " + result);
	}

}
