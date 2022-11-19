package com.example.demo_foodMap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "search")
public class Search {

	@Id
	@Column(name = "shopName")
	private String shopName;

	@Column(name = "city")
	private String city;

	@Column(name = "shopComment")
	private double shopComment;

	public Search() {

	}

	public Search(String city, String shopName) {
		this.city = city;
		this.shopName = shopName;
	}

	public Search(String city, String shopName, double shopComment) {
		this.city = city;
		this.shopName = shopName;
		this.shopComment = shopComment;
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

}
