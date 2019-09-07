package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {

//	@Before("execution(String com.demo.vehicles.Car.drive(..))")
//	public void vehicleAboutToMove(JoinPoint jp) {
//		System.out.println("Saving from aspect (from aspect): Vehicle action: About to move");
//		System.out.println("JoinPoint type " + jp.getKind());
//		System.out.println("JoinPoint static part " + jp.getStaticPart());
//		
//		Object[] args = jp.getArgs();
//		Integer speed = ((Integer)args[0]).intValue();
//		System.out.println("JoinPoint argument speed: " + speed);
//		System.out.println("JoinPoint target " + jp.getTarget());
//		System.out.println("JoinPoint signature " + jp.getSignature());
//	}
//	
//	@AfterReturning(pointcut="execution(String com.demo.vehicles.Car.drive(..))", returning="ret")
//	public void vehicleMoved(String ret) {
//		System.out.print("Car is moving now: ");
//		System.out.println(ret);
//	}
//	
//	@AfterThrowing(pointcut="execution(String com.demo.vehicles.Car.drive(..))", throwing="ex")
//	public void vehicleThrewExcDuringMoving(Exception ex) {
//		System.out.println(ex.getMessage());
//	}
//	
//	@After("execution(String com.demo.vehicles.Car.drive(..))")
//	public void vehicleCouldMove() {
//		System.out.println("Executed regardless exceptions");
//	}
	
	//works when other advises are disabled
	@Around("execution(String com.demo.vehicles.Car.drive(..))")
	//public void vehicleStartEndMoving(ProceedingJoinPoint pjp) throws Throwable {
	public String vehicleStartEndMoving(ProceedingJoinPoint pjp) throws Throwable {
		String result = "";
		
		System.out.println("Around: I'm running before");
		
		Object[] originalArgs = pjp.getArgs();
		int speed = (Integer)originalArgs[0];
		if (speed >= 50) speed = 50;
		
		Object[] newArgs = new Object[1];
		newArgs[0] = new Integer(speed);
		
		try {
			//pjp.proceed();
			result = (String)pjp.proceed(newArgs);
			
		} catch (Exception e) {
			System.out.println("AROUND: Catching the exception");
		}
		System.out.println("Around: I'm running after");
		
		return result;
	}
	
}
