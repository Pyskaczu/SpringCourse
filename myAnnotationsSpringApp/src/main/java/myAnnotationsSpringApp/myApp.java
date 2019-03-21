package myAnnotationsSpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import food.Fruit;
import food.Meal;
import food.ReducedMeal;
import food.Vegetable;

public class myApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
//		ApplicationContext appContext = new ClassPathXmlApplicationContext("myTestPackage/appContext.xml");
		
		Meal myMeal = appContext.getBean("mealByAnnotation", Meal.class);
		System.out.println(myMeal.whatsInThisMeal());
		
//		Fruit f = appContext.getBean("fruit", Fruit.class);
//		System.out.println(f.tellAboutYourself());
//		
//		Fruit f = appContext.getBean("fruit", Fruit.class);
//		Vegetable v = (Vegetable)appContext.getBean("vegetable");
//		
//		System.out.println(f.tellAboutYourself());
//		System.out.println(v.tellAboutYourself());
//		System.out.println(f.getDefinition());
//		
//		f = appContext.getBean("fruitWithName", Fruit.class);
//		v  = (Vegetable)appContext.getBean("vegetableWithName");
//		System.out.println(f.tellAboutYourself());
//		System.out.println(v.tellAboutYourself());
//		
//		f = appContext.getBean("fruitWithNameListAndMap", Fruit.class);
//		System.out.println(f.tellAboutYourself());
//		
//		v  = (Vegetable)appContext.getBean("vegUsingPNamespace");
//		System.out.println(v.tellAboutYourself());
//		
//		Meal myMeal = new Meal();
//		System.out.println(myMeal.whatsInThisMeal());
//		
//		myMeal = appContext.getBean("mealMethodInj", Meal.class);
//		System.out.println(myMeal.whatsInThisMeal());
//		
//		myMeal = appContext.getBean("mealConstructorIndexInj", Meal.class);
//		System.out.println(myMeal.whatsInThisMeal());
//		
//		myMeal = appContext.getBean("mealConstructorNameInj", Meal.class);
//		System.out.println(myMeal.whatsInThisMeal());
//		
//		myMeal = appContext.getBean("mealOuterBean", Meal.class);
//		System.out.println(myMeal.whatsInThisMeal());
//		
//		ReducedMeal reducedMeal = appContext.getBean("reducedMealAutowireByType", ReducedMeal.class);
//		System.out.println(reducedMeal.whatsInThisMeal());
//		
//		reducedMeal = appContext.getBean("reducedMealAutowireByName", ReducedMeal.class);
//		System.out.println(reducedMeal.whatsInThisMeal());
//		
//		reducedMeal = appContext.getBean("reducedMealAutowireConstructor", ReducedMeal.class);
//		System.out.println(reducedMeal.whatsInThisMeal());
		
		((FileSystemXmlApplicationContext) appContext).close();
	}
}
