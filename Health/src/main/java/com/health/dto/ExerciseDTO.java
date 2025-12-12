package com.health.dto;

public class ExerciseDTO {
	
	private int ex_id;
	private String category;
	private String name;
	private int kcal_burn;
	
	
	public int getEx_id() {
		return ex_id;
	}
	public void setEx_id(int ex_id) {
		this.ex_id = ex_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKcal_burn() {
		return kcal_burn;
	}
	public void setKcal_burn(int kcal_burn) {
		this.kcal_burn = kcal_burn;
	}
	
	

}
