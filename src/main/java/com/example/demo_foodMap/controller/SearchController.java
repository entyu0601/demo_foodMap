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

	/* �s�W ���a�����B���W */
	@PostMapping(value = "/api/createSearch")
	public SearchResp createSearch(@RequestBody SearchReq req) {
		return searchService.createSearch(req.getCity(), req.getShopName());
	}

	/* �s�W ���W�B�\�I�B����B�\�I����(1~5�P)�� */
	@PostMapping(value = "/api/createStore")
	public SearchResp createStore(@RequestBody SearchReq req) {
		return searchService.createStore(req.getShopName(), req.getMeals(), req.getPrice(), req.getMealsComment());
	}

	/* �Ϋ�����X�Ҧ����a�A����� */
	@PostMapping(value = "/api/getShopByCity")
	public SearchResp getShopByCity(@RequestBody SearchReq req) {
		return searchService.getShopByCity(req.getCity(), req.getRecord());
	}

}
