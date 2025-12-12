package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {
	
	@Around("execution(public void com..aop.*.*(..))")
	public Object aroundMethodCall(ProceedingJoinPoint jointPoint) {
		
		Object result = null;
		
		try {
			
			System.out.println("메소드 실행전(AroundBefore)...");
			result = jointPoint.proceed();
			System.out.println("메소드 실행후(AroundAfter)...");
			
		} catch (Throwable e) {
			
		}
		return result;
	}

}
