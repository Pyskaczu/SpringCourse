package myJavaBasedConfgSpringApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import food.Apple;
import food.Dairy;
import food.Fruit;
import food.Grain;
import food.Meal;
import food.Meat;
import food.Vegetable;

@Configuration
@ComponentScan({"food"})
public class AppContext {
	
	@Bean(name="fruit")
	public Fruit getFruit() {
		return new Fruit();
	}
	
	@Bean(name="apple")
	public Apple getApple() {
		return new Apple();
	}
	
	@Bean(name="vegetable")
	public Vegetable getVegetable() {
		return new Vegetable();
	}
	
	@Bean(name="dairy")
	public Dairy getDairy() {
		return new Dairy();
	}
	
	@Bean(name="grain")
	public Grain getGrain() {
		return new Grain();
	}
	
	@Bean(name="meat")
	public Meat getMeat() {
		return new Meat();
	}
	
	@Bean(name="meal")
	public Meal getMeal() {
		Meal myMeal = new Meal();
		
//		myMeal.setFruitA(getFruit());
		//and so on
		
//		myMeal = new Meal(getFruit(),getFruit(), getVegetable(), getDairy(), getGrain(), getMeat());
		
		return myMeal;
	}
}
