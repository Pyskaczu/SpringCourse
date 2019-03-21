package com.demo.vehicles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class aspectsApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
		
		Car car = appContext.getBean("car", Car.class);

		car.drive();
		
		((FileSystemXmlApplicationContext) appContext).close();
		
	}

}
