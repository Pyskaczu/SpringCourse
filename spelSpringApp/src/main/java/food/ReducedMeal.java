package food;

public class ReducedMeal {

	private Dairy dairy;
	private Grain grain;
	private Meat meat;
	private String description;

	public ReducedMeal() {
	}

	public ReducedMeal(Dairy dairy, Grain grain, Meat meat) {
		this.grain = grain;
		this.dairy = dairy;
		this.meat = meat;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String whatsInThisMeal() {
		String answear = "This " + description + "meal contains: ";
		if (null != dairy)
			answear += "some dairy: ";
		if (null != meat)
			answear += "some meat: ";
		if (null != grain)
			answear += "some grain: ";

		return answear;
	}

}
