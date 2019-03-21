package food;

import java.util.List;
import java.util.Map;

import javax.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
//@Component("fruit")
public class Fruit {

	private String name;
	private List<String> fruitNameList;
	private Map<String, String> fruitNameMap;

	private String definition = "not set";

	public Fruit() {
	}

	public Fruit(String name) {
		setName(name);
	}

	@Autowired
	public void setName(@Value("annotated Apple") String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String tellAboutYourself() {
		String speech = "Hello! I'm a friut.";
		if (null != name && !name.isEmpty()) {
			speech = "Hello! I'm " + name + ".";
		}

		if (null != fruitNameList && fruitNameList.size() > 0) {
			speech += "\nList:";
			for (String fruitName : fruitNameList) {
				speech += "\n" + fruitName;
			}
		}

		if (null != fruitNameMap && fruitNameMap.size() > 0) {
			speech += "\nMap:";
			for (Map.Entry<String, String> entry : fruitNameMap.entrySet()) {
				speech += "\n" + entry.getKey() + ":" + entry.getValue();
			}
		}

		return speech;
	}

	public List<String> getFruitNameList() {
		return fruitNameList;
	}

	public void setFruitNameList(List<String> fruitNameList) {
		this.fruitNameList = fruitNameList;
	}

	public Map<String, String> getFruitNameMap() {
		return fruitNameMap;
	}

	public void setFruitNameMap(Map<String, String> fruitNameMap) {
		this.fruitNameMap = fruitNameMap;
	}

	public String getDefinition() {
		return definition;
	}

//	@Required
	public void setDefinition(String definition) {
		this.definition = definition;
	}

	@SuppressWarnings("restriction")
	@PostConstruct
	public void initMethod() {
		System.out.println("Fruit initMethod");
	}

	@SuppressWarnings("restriction")
	@PreDestroy
	public void destroyMethod() {
		System.out.println("Fruit destroyMethod");
	}
}
