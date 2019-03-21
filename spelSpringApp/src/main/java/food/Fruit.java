package food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("fruit")
public class Fruit {

	private String name;
	
	private int nutritionalRating;
	
	public Fruit() {}
	
	public Fruit(String name) {
		setName(name);
	}
	
	@Autowired
//	public void setName(@Value("#{T(food.DataSource).getAppleTypeStatic()?.toUpperCase() + ' APPLE'}")String name) {
	public void setName(@Value("#{T(food.DataSource).getAppleTypeStatic().toUpperCase() + ' APPLE'}")String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNutritionalRating() {
		return nutritionalRating;
	}

	public void setNutritionalRating(int nutritionalRating) {
		this.nutritionalRating = nutritionalRating;
	}

	public String tellAboutYourself() {
		String speech = "Hello! I'm a friut.";
		if(null != name && !name.isEmpty()) {
			speech = "Hello! I'm " + name + ".";
		}
		
		if(nutritionalRating > 0) {
			speech += "\nMy nutritional rating is " + nutritionalRating + ".";
		}
		
		return speech;
	}
}
