package food;


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
