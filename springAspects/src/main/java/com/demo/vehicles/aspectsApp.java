package com.demo.vehicles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.config.AppConfig;

public class aspectsApp {

	public static void main(String[] args) {
		//ApplicationContext appContext = new FileSystemXmlApplicationContext("src\\main\\java\\com\\demo\\config\\appContext.xml");
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		Car car = appContext.getBean("car", Car.class);

		String result = car.drive(112);
		System.out.println("MAIN: " + result);
		
		((FileSystemXmlApplicationContext) appContext).close();
		
	}

}
