package com.demo.vehicles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.config.AppConfig;
import com.demo.sportsEquipment.GolfClubDesignators;
import com.demo.vehicles.offroad.DirtBikeDesignators;
import com.demo.vehicles.offroad.FourWheelerDesignators;

public class aspectsApp {

	public static void main(String[] args) {
		//ApplicationContext appContext = new FileSystemXmlApplicationContext("src\\main\\java\\com\\demo\\config\\appContext.xml");
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("******************** Advice **************************************");
		CarAdvice carAdvice = appContext.getBean("carAdvice", CarAdvice.class);

		String result = carAdvice.drive(112);
		System.out.println("MAIN: " + result);
		
		System.out.println("******************** Pointcut ************************************");
		
		CarPointcut carPointcut = appContext.getBean("carPointcut", CarPointcut.class);
		carPointcut.drive(30);
		carPointcut.drift();
		carPointcut.drive("Hello");
		carPointcut.stop();
		
		System.out.println("******************** Designators *********************************");
		
		CarDesignators carDesignators = appContext.getBean("carDesignators", CarDesignators.class);
		DirtBikeDesignators dirtBikeDesignators = appContext.getBean("dirtBikeDesignators", DirtBikeDesignators.class);
		FourWheelerDesignators fourWheelerDesignators = appContext.getBean("fourWheelerDesignators", FourWheelerDesignators.class);
		GolfClubDesignators golfClubDesignators = appContext.getBean("golfClubDesignators", GolfClubDesignators.class);
		
		carDesignators.drive();
		carDesignators.drive(10);
		carDesignators.drive(10, 20);
		carDesignators.drive("Shooooouting");
		dirtBikeDesignators.drive();
		fourWheelerDesignators.drive();
		golfClubDesignators.drive();
		
		
		
		//((FileSystemXmlApplicationContext) appContext).close();
		((AnnotationConfigApplicationContext) appContext).close();
		
	}

}
