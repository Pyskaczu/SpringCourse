package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogDesignators {

//	@Before("execution(* *(..))") // methods
	
//	@Before("within(com.demo.vehicles.*)") //package
//	@Before("within(com.demo.vehicles..*)") //package and subpackages
	
//	@Before("args()")
//	@Before("args(String)")
//	@Before("args(int, int)")
//  @Before("args(*)")
//	@Before("args(..)")
//	@Before("bean(carDesignators)")
//	@Before("bean(car*)")
	
//	@Before("execution(@com.demo.aop.RandomDemoAnnotation * *(..))") // all annotated methods  
//	@Before("execution(* (@com.demo.aop.RandomDemoAnnotation *).* (..))") // all annotated methods  
	@Before("@annotation(RandomDemoAnnotation)") // does not want to work
	public void performLogging(JoinPoint jp) {
		System.out.println("------------------------------------");
		System.out.println("Saving to log (from aspect)");
		System.out.println("Actual JoinPoint: " + jp.getStaticPart());
	}
	
	@Before("args(var1, var2)")
	public void performLogging(JoinPoint jp, int var1, int var2) {
		System.out.println("------------------------------------");
		System.out.println("Saving to log (from aspect with arguments)");
		System.out.println("Actual JoinPoint: " + jp.getStaticPart());
	}

}
