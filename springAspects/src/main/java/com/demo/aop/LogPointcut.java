package com.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogPointcut {

//	@Before("anyMethodInCarThatStartsWithDr()")
//	@Before("anyMethodInCarThatReturmsString()")
//	@Before("anyMethodInCarThatStartsWithDr() && anyMethodInCarThatReturmsString()")
//	@Before("anyMethodInCarThatStartsWithDr() || anyMethodInCarThatReturmsString()")
	@Before("!anyMethodInCarThatStartsWithDr()")
	public void vehicleAboutToTakeAction() {
		System.out.println("Saving to log from aspect: " + "vehicleAboutToTakeAction");
	}
	
	@Pointcut("execution(* com.demo.vehicles.CarPointcut.dr*(..))")
//	@Pointcut("execution(* com.demo.vehicles.CarPointcut.drive(int, *))")
	public void anyMethodInCarThatStartsWithDr(){}
	
	@Pointcut("execution(String *(..))")
	public void anyMethodInCarThatReturmsString(){}
}
