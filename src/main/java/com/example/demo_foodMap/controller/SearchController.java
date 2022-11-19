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

	/* 穝糤 ┍產カ┍ */
	@PostMapping(value = "/api/createSearch")
	public SearchResp createSearch(@RequestBody SearchReq req) {
		return searchService.createSearch(req.getCity(), req.getShopName());
	}

	/* 穝糤 ┍繺翴基繺翴蝶基(1~5琍)单 */
	@PostMapping(value = "/api/createStore")
	public SearchResp createStore(@RequestBody SearchReq req) {
		return searchService.createStore(req.getShopName(), req.getMeals(), req.getPrice(), req.getMealsComment());
	}

	/* ノカт┮Τ┍產掸计 */
	@PostMapping(value = "/api/getShopByCity")
	public SearchResp getShopByCity(@RequestBody SearchReq req) {
		return searchService.getShopByCity(req.getCity(), req.getRecord());
	}

}
