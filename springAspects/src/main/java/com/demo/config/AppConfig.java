package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.demo.vehicles.Car;

@Configuration
@ComponentScan("com.demo.aop")
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean(name="car")
	public Car getCar() {
		return new Car();
	}
}
