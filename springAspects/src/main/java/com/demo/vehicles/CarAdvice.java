package com.demo.vehicles;

public class CarAdvice {

	public String drive(int speed) {
		
		//meeting tracing concern
		//System.out.println("Saving to log (from Car class): Car is driving");
		
		//actual business logic for driving 
		System.out.println("Driving at " + speed);
		
		boolean canMove = true;
		//boolean canMove = false;
		
		if(canMove) {
			return "I can move";
		} else {
			throw new RuntimeException("NEED PETROL");
		}
	
	}
	
	public void stop() {
		System.out.println("Braking to a stop");
	}
}
