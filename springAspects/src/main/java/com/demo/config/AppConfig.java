package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.demo.sportsEquipment.GolfClubDesignators;
import com.demo.vehicles.CarAdvice;
import com.demo.vehicles.CarDesignators;
import com.demo.vehicles.CarPointcut;
import com.demo.vehicles.offroad.DirtBikeDesignators;
import com.demo.vehicles.offroad.FourWheelerDesignators;

@Configuration
@ComponentScan("com.demo.aop")
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean(name="carAdvice")
	public CarAdvice getCarAdvice() {
		return new CarAdvice();
	}
	
	@Bean(name="carPointcut")
	public CarPointcut getCarPointcut() {
		return new CarPointcut();
	}
	
	@Bean(name="carDesignators")
	public CarDesignators getCarDesignators() {
		return new CarDesignators();
	}
	
	@Bean(name="dirtBikeDesignators")
	public DirtBikeDesignators getDirtBikeDesignators() {
		return new DirtBikeDesignators();
	}
	
	@Bean(name="fourWheelerDesignators")
	public FourWheelerDesignators getFourWheelerDesignators() {
		return new FourWheelerDesignators();
	}
	
	@Bean(name="golfClubDesignators")
	public GolfClubDesignators getGolfClubDesignators() {
		return new GolfClubDesignators();
	}
	
}
