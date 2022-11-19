package com.example.demo_foodMap.entity;

import java.io.Serializable;

@SuppressWarnings("serial") // 忽略警告(不用裡他)
public class ShopMealsId implements Serializable {

	private String shopName;

	private String meals;

	public ShopMealsId() {

	}

	public ShopMealsId(String shopName, String meals) {
		this.shopName = shopName;
		this.meals = meals;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getMeals() {
		return meals;
	}

	public void setMeals(String meals) {
		this.meals = meals;
	}

}
