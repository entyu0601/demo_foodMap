package com.example.demo_foodMap.service.ifs;

import com.example.demo_foodMap.vo.SearchResp;

public interface SearchService {

	// �s�W ���a�����B���W
	public SearchResp createSearch(String city, String shopName);

	// �s�W ���W�B�\�I�B����B�\�I����(1~5�P)
	public SearchResp createStore(String shopName, String meals, int price, double mealsComment);

	// �Ϋ�����X�Ҧ����a�A�����
	public SearchResp getShopByCity(String city,int record);
}
