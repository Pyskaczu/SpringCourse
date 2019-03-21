package food;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import food.annot.AnotherRandomDemoAnnotation;
import food.annot.RandomDemoAnnotation;

@Component("vegetable")
//@Named

//@RandomDemoAnnotation
@AnotherRandomDemoAnnotation
public class Vegetable {

	private String name;

	public Vegetable() {
	}

	public Vegetable(String name) {
		setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String tellAboutYourself() {
		String speech = "Hello! I'm a vegetable.";
		if (null != name && !name.isEmpty()) {
			speech = "Hello! I'm " + getName() + ".";
		}

		return speech;
	}
}
