package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.demo.exceptions.ExampleException;
/**
 * https://www.baeldung.com/spring-aop-annotation
 * https://howtodoinjava.com/spring-boot2/aop-aspectj/
 * https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html
 * https://stackoverflow.com/questions/15660535/get-method-arguments-using-spring-aop
 * 
 * **/
@Aspect
@Component
public class AOPLogger {
	
	@Before("execution(* com.example.demo.aop.AOPService.beforeTest(..))")
	public void beforeTest() {
		System.out.println("Inside the before pointcut method");
	}
	
	@After("execution(* com.example.demo.aop.AOPService.afterTest(..))")
	public void afterTest() {
		System.out.println("Inside the after pointcut method");
	}
	
	@AfterReturning(pointcut = "execution(* com.example.demo.aop.AOPService.afterReturning(..))", returning = "value")
	public void afterReturn(Object value) {
		System.out.println("Inside the after returning pointcut method");
		System.out.println(value);
	}
	
	@AfterThrowing(pointcut = "execution(* com.example.demo.aop.AOPService.afterThrowing(..))", throwing = "value")
	public void afterReturn(ExampleException value) {
		System.out.println("Inside the after throwing returning pointcut method");
		System.out.println(value.getMessage());
	}
	
	@Around("execution(* com.example.demo.aop.AOPService.aroundTest(..))")
	public void afterReturn(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Inside the around pointcut method before pjp proceeds");
		pjp.proceed();
		System.out.println("Inside the around pointcut method after pjp proceeds");
	}
	
	@Around("execution(* com.example.demo.aop.AOPService.aroundTestWithReturnValue(..))")
	public Object afterReturnValue(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Inside the around with return pointcut method before pjp proceeds");
		Object output = pjp.proceed();
		System.out.println("Inside the around with return pointcut method after pjp proceeds");
		return output;
	}
	
	@Around("execution(* com.example.demo.aop.AOPService.aroundTestWithParams(..))")
	public void aroundTestWithParams(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Inside the around with return pointcut method before pjp proceeds");
		for (Object param : pjp.getArgs()) {
			System.out.println("Value : " + param);
		}
		pjp.proceed();
		System.out.println("Inside the around with return pointcut method after pjp proceeds");
	}

}
