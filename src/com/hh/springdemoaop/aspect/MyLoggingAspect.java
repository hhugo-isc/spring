package com.hh.springdemoaop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyLoggingAspect {

	private Logger myLogger = Logger.getLogger(MyLoggingAspect.class.getName());

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
//	@AfterReturning(pointcut = "execution(* com.hh.springdemoaop.dao.AccountDao.findAccounts(..))", returning = "result")
//	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
////		print out what method we are advising on
//		String method = joinPoint.getSignature().toShortString();
//		System.out.println("\n=========>>> Executing @AfterReturning on method: " + method);
////		print out the results of the method call
//		System.out.println("\n=========>>> result is: " + result);
//
////		let's post-process the data ... let's modify it :-
////		convert the account name to uppercase
//		convertNameToUpperCase(result);
//
//		System.out.println("\n=========>>> result is: " + result);
//
//	}
//
//	private void convertNameToUpperCase(List<Account> result) {
//		for (Account account : result) {
//			account.setName(account.getName().toUpperCase());
//		}
//	}
//
//	@AfterThrowing(pointcut = "execution(* com.hh.springdemoaop.dao.AccountDao.findAccounts(..))", throwing = "ex")
//	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex) {
////		print out which method we are advising on
//		String method = joinPoint.getSignature().toShortString();
//		System.out.println("\n=========>>> Executing @AfterThrowing on method: " + method);
////		log the exception
//		System.out.println("\n=========>>> The exception is: " + ex);
//	}
//
//	@After("execution(* com.hh.springdemoaop.dao.AccountDao.findAccounts(..))")
//	public void afterFinallyFindAccountsAdvide(JoinPoint joinPoint) {
////		print out which method we are advising on
//		String method = joinPoint.getSignature().toShortString();
//		System.out.println("\n=========>>> Executing @After (finally) on method: " + method);
//	}

	@Around("execution(* com.hh.springdemoaop.service.*.getFortune(..))")
	public Object arroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
//		print out the method we are advising
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=========>>> Executing @Around on method: " + method);

//		get begin timestamp
		long beginTimeStamp = System.currentTimeMillis();

//		now, let's execute the method
		Object result = joinPoint.proceed();

//		get end timestamp
		long endTimesTamp = System.currentTimeMillis();

//		compute duration and display it
		long duration = endTimesTamp - beginTimeStamp;
		myLogger.info("\n=========>>> Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

}
