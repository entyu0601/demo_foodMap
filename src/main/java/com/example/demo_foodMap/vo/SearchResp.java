package com.example.demo_foodMap.vo;

import java.util.List;

import com.example.demo_foodMap.entity.Search;
import com.example.demo_foodMap.entity.Shop;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchResp {

	@JsonProperty("search_info")
	private Search search;

	@JsonProperty("shop_info")
	private Shop shop;

	private String message;

	private int record;

	private List<Search> shopList;

	private List<Shop> shopNameList;

	public SearchResp() {

	}

	public SearchResp(int record, List<Shop> shopNameList, String message) {
		this.record = record;
		this.shopNameList = shopNameList;
		this.message = message;
	}

	public SearchResp(List<Search> shopList, String message) {
		this.shopList = shopList;
		this.message = message;
	}

	public SearchResp(Search search, String message) {
		this.search = search;
		this.message = message;
	}

	public SearchResp(Shop shop, String message) {
		this.shop = shop;
		this.message = message;
	}

	public SearchResp(String message) {
		this.message = message;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Search> getShopList() {
		return shopList;
	}

	public void setShopList(List<Search> shopList) {
		this.shopList = shopList;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}

	public List<Shop> getShopNameList() {
		return shopNameList;
	}

	public void setShopNameList(List<Shop> shopNameList) {
		this.shopNameList = shopNameList;
	}

}
