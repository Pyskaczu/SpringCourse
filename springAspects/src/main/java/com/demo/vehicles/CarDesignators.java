package com.demo.vehicles;

import com.demo.aop.RandomDemoAnnotation;

@RandomDemoAnnotation
public class CarDesignators {

//	@RandomDemoAnnotation
	public void drive() {
		System.out.println("CarDesignators: I'm driving");
	}
	
	public int drive(int maxSpeed) {
		System.out.println("CarDesignators: I'm driving at max speed: " + maxSpeed);
		return maxSpeed;
	}
	
	public int drive(int minSpeed, int maxSpeed) {
		System.out.println("CarDesignators: I'm driving at min speed: " + minSpeed);
		System.out.println("CarDesignators: I'm driving at max speed: " + maxSpeed);
		return maxSpeed;
	}
	
	public String drive(String shoutOutWindow) {
		System.out.println("CarDesignators: I'm shouting: " + shoutOutWindow);
		return shoutOutWindow;
	}
	
	public void stop() {
		System.out.println("CarDesignators: Braking to a stop");
	}
}
