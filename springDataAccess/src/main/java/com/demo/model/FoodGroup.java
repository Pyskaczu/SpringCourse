package com.demo.model;

public class FoodGroup {

	private int id;
	private String name;
	private String description;

	public FoodGroup(int id, String name, String descriprion) {
		this.id = id;
		this.name = name;
		this.description = descriprion;
	}
	
	public FoodGroup(String name, String descriprion) {
		this(0, name, descriprion);
	}
	
	public FoodGroup() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String talkAboutYourself() {
		return "Food group name: " + name + "\tFood group description: " + description + "\tFood group id: " + id;
	}
}
