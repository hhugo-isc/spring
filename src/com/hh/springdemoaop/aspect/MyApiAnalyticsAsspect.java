package com.hh.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAsspect {

	@Before("com.hh.springdemoaop.aspect.LuvAopExpressions.forDaoPackageAndExludeGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n----->>> Performing API Analytics");
	}

}
