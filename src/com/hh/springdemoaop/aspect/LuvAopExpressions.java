package com.hh.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	@Pointcut("execution(* com.hh.springdemoaop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.hh.springdemoaop.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.hh.springdemoaop.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageAndExludeGetterAndSetter() {
	}
}
