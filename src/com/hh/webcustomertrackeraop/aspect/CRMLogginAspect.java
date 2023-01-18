package com.hh.webcustomertrackeraop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogginAspect {
//	setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

//	setup pointcuts
	@Pointcut("execution(* com.hh.webcustomertrackeraop.controller.*.*(..))")
	public void forControllerPackage() {
	}

	@Pointcut("execution(* com.hh.webcustomertrackeraop.service.*.*(..))")
	public void forServicePackage() {
	}

	@Pointcut("execution(* com.hh.webcustomertrackeraop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {
	}

//	add @before advice
	@Before("forAppFlow()")
	public void beforeAppFlow(JoinPoint joinPoint) {
//		display method we are calling
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("=========>>> in @Before: calling method: " + method);
//		display the arguments
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			myLogger.info("=========>>> argument: " + arg);
		}
	}

//	add @afterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterAppFlow(JoinPoint joinPoint, Object theResult) {
//		display method we are returning from
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("=========>>> in @AfterReturning: from method: " + method);

		// display data returned
		myLogger.info("=========>>> result: " + theResult + "\n");

	}

}
