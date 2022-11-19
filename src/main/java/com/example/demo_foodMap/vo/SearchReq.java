package com.example.demo_foodMap.vo;

public class SearchReq {

	private String shopName;

	private String city;

	private double shopComment;

	private String meals;

	private int price;

	private int record;

	private double mealsComment;

//	@JsonProperty("courseCode_set")
//	private Set<String> courseCodeSet;

	public SearchReq() {

	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getShopComment() {
		return shopComment;
	}

	public void setShopComment(double shopComment) {
		this.shopComment = shopComment;
	}

	public String getMeals() {
		return meals;
	}

	public void setMeals(String meals) {
		this.meals = meals;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getMealsComment() {
		return mealsComment;
	}

	public void setMealsComment(double mealsComment) {
		this.mealsComment = mealsComment;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}

}
