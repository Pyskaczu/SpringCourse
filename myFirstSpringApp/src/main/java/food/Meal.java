package food;

public class Meal {
	
	private Fruit fruit;
	private Vegetable vegetable;
	private Dairy dairy;
	private Grain grain;
	private Meat meat;
	
	public Meal() {}
	
	public Meal(Fruit fruit, Vegetable vegetable, Dairy dairy, Grain grain, Meat meat) {
		this.fruit = fruit;
		this.vegetable = vegetable;
		this.grain = grain;
		this.dairy = dairy;
		this.meat = meat;
	}
	
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	public Vegetable getVegetable() {
		return vegetable;
	}
	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}
	public Dairy getDairy() {
		return dairy;
	}
	public void setDairy(Dairy dairy) {
		this.dairy = dairy;
	}
	public Grain getGrain() {
		return grain;
	}
	public void setGrain(Grain grain) {
		this.grain = grain;
	}
	public Meat getMeat() {
		return meat;
	}
	public void setMeat(Meat meat) {
		this.meat = meat;
	}
	
	public String whatsInThisMeal() {
		String answear = "This meal contains: ";
		if(null != fruit)  answear += "some fruit: " + fruit.tellAboutYourself() + ": ";
		if(null != vegetable) answear += "some vegetable: ";
		if(null != dairy) answear += "some dairy: ";
		if(null != meat) answear += "some meat: ";
		if(null != grain) answear += "some grain: ";
		
		return answear;
	}
	
}
