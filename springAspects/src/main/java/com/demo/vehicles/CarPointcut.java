package com.demo.vehicles;

public class CarPointcut {

	public void drive() {
		System.out.println("I'm driving");
	}
	
	public int drive(int maxSpeed) {
		System.out.println("I'm driving at max speed: " + maxSpeed);
		return maxSpeed;
	}
	
	public String drive(String shoutOutWindow) {
		System.out.println("Shouting out of the window: " + shoutOutWindow);
		return shoutOutWindow;
	}
	
	public void drift() {
		System.out.println("I'm drifting");
	}
	
	public String stop() {
		System.out.println("Braking to a stop");
		return "Stopped";
	}
}
