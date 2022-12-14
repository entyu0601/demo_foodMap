package com.example.demo_foodMap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_foodMap.service.ifs.SearchService;
import com.example.demo_foodMap.vo.SearchReq;
import com.example.demo_foodMap.vo.SearchResp;

@RestController
public class SearchController {

	@Autowired
	private SearchService searchService;

	/* 新增 店家城市、店名 */
	@PostMapping(value = "/api/createSearch")
	public SearchResp createSearch(@RequestBody SearchReq req) {
		return searchService.createSearch(req.getCity(), req.getShopName());
	}

	/* 新增 店名、餐點、價格、餐點評價(1~5星)等 */
	@PostMapping(value = "/api/createStore")
	public SearchResp createStore(@RequestBody SearchReq req) {
		return searchService.createStore(req.getShopName(), req.getMeals(), req.getPrice(), req.getMealsComment());
	}

	/* 用城市找出所有店家，限制筆數 */
	@PostMapping(value = "/api/getShopByCity")
	public SearchResp getShopByCity(@RequestBody SearchReq req) {
		return searchService.getShopByCity(req.getCity(), req.getRecord());
	}

}
