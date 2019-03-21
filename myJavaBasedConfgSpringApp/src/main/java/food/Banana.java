package food;

public class Banana extends Fruit {

	private String description;
	private String name;

	public String tellAboutYourself() {
		String result = super.tellAboutYourself();
		if (null != name)
			result += "I'm " + name + ". ";
		if (null != description)
			result += description;
		return result;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
