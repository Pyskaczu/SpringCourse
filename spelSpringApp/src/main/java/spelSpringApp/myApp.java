package spelSpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import food.Fruit;
import food.Meal;
import food.OsName;

public class myApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
		
		Fruit f = appContext.getBean("fruit", Fruit.class);
		System.out.println(f.tellAboutYourself());
		
		Meal m = appContext.getBean("meal", Meal.class);
		System.out.println(m.getFruitName());
		
		OsName osName = appContext.getBean("osName", OsName.class);
		System.out.println(osName.getOsName());
		
		((FileSystemXmlApplicationContext) appContext).close();
	}
}
