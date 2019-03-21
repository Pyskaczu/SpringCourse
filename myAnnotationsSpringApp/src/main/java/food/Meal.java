package food;

import javax.annotation.*;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Meal {

	
	@Autowired
	@Qualifier(value="fruitA")
	
//	@SuppressWarnings("restriction")
//	@Resource(name="fruitA")
	
//	@Inject
//	@Name("fruitA")
	private Fruit fruitA;
	
	@Autowired
	@Qualifier(value="fruitB")
	private Fruit fruitB;
	
//	@Autowired
	private Vegetable vegetable;
//	@Autowired
	private Dairy dairy;
//	@Autowired
	private Grain grain;
//	@Autowired
	private Meat meat;

	public Meal() {
	}

//	@Autowired
	public Meal(Fruit fruitA, Fruit fruitB, Vegetable vegetable, Dairy dairy, Grain grain, Meat meat) {
		this.setFruitA(fruitA);
		this.setFruitB(fruitB);
		this.vegetable = vegetable;
		this.grain = grain;
		this.dairy = dairy;
		this.meat = meat;
	}

	public Vegetable getVegetable() {
		return vegetable;
	}

//	@Autowired
	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}

	public Dairy getDairy() {
		return dairy;
	}

	@Autowired
	public void setDairy(Dairy dairy) {
		this.dairy = dairy;
	}

	public Grain getGrain() {
		return grain;
	}

	@Autowired
	public void setGrain(Grain grain) {
		this.grain = grain;
	}

	public Meat getMeat() {
		return meat;
	}

	@Autowired
	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	public String whatsInThisMeal() {
		String answear = "This meal contains: ";
		if (null != getFruitA())
			answear += "some fruit: " + getFruitA().tellAboutYourself() + ": ";
		if (null != getFruitB())
			answear += "some fruit: " + getFruitB().tellAboutYourself() + ": ";
		if (null != vegetable)
			answear += "some vegetable: ";
		if (null != dairy)
			answear += "some dairy: ";
		if (null != meat)
			answear += "some meat: ";
		if (null != grain)
			answear += "some grain: ";

		return answear;
	}

	public Fruit getFruitA() {
		return fruitA;
	}

	public void setFruitA(Fruit fruitA) {
		this.fruitA = fruitA;
	}

	public Fruit getFruitB() {
		return fruitB;
	}

	public void setFruitB(Fruit fruitB) {
		this.fruitB = fruitB;
	}

}
