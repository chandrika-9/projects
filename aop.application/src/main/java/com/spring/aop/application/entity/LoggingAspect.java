package com.spring.aop.application.entity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* com.spring.aop.application.*.*(..))")

	public void logAfter(JoinPoint joinPoint) {
		System.out.println("Method executed: " + joinPoint.getSignature().getName());
	}
	
	

}
