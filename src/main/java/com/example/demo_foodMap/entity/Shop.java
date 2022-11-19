package com.example.demo_foodMap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Shop")
@IdClass(value = ShopMealsId.class)
public class Shop {

	@Id
	@Column(name = "shopName")
	private String shopName;

	@Id
	@Column(name = "meals")
	private String meals;

	@Column(name = "price")
	private int price;

	@Column(name = "mealsComment")
	private double mealsComment;

	public Shop() {

	}
	
	public void updateShop(String meals, int price, double mealsComment) {
		this.meals = meals;
		this.price = price;
		this.mealsComment = mealsComment;
	}

	public Shop(String shopName, String meals, int price, double mealsComment) {
		this.shopName = shopName;
		this.meals = meals;
		this.price = price;
		this.mealsComment = mealsComment;
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

}
