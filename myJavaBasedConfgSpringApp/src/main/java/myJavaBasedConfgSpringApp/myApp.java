package myJavaBasedConfgSpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import food.Meal;

public class myApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppContext.class);
		
		Meal myMeal = appContext.getBean("meal", Meal.class);
		System.out.println(myMeal.whatsInThisMeal());
		
		((AnnotationConfigApplicationContext) appContext).close();
	}
}
