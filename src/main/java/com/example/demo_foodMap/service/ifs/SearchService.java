package com.example.demo_foodMap.service.ifs;

import com.example.demo_foodMap.vo.SearchResp;

public interface SearchService {

	// 新增 店家城市、店名
	public SearchResp createSearch(String city, String shopName);

	// 新增 店名、餐點、價格、餐點評價(1~5星)
	public SearchResp createStore(String shopName, String meals, int price, double mealsComment);

	// 用城市找出所有店家，限制筆數
	public SearchResp getShopByCity(String city,int record);
}
