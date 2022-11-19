package com.example.demo_foodMap.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo_foodMap.constants.SearchRtnCode;
import com.example.demo_foodMap.entity.Search;
import com.example.demo_foodMap.entity.Shop;
import com.example.demo_foodMap.repository.SearchDao;
import com.example.demo_foodMap.repository.ShopDao;
import com.example.demo_foodMap.service.ifs.SearchService;
import com.example.demo_foodMap.vo.SearchResp;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;

	@Autowired
	private ShopDao shopDao;

	/* 新增 店家城市、店名 */
	@Override
	public SearchResp createSearch(String city, String shopName) {

		if (!StringUtils.hasText(city) || !StringUtils.hasText(shopName)) {
			return new SearchResp(SearchRtnCode.VALUE_REQUIRED.getMessage());
		}

		Optional<Search> cityOp = searchDao.findById(shopName);
		if (cityOp.isPresent()) {
			return new SearchResp(SearchRtnCode.STORE_EXISTED.getMessage());
		} else {
			Search search = new Search(city, shopName);
			searchDao.save(search);
			return new SearchResp(search, SearchRtnCode.CREATE_SUCCESSFUL.getMessage());
		}
	}

	/* 新增 店名、餐點、價格、餐點評價(1~5星) */
	@Override
	public SearchResp createStore(String shopName, String meals, int price, double mealsComment) {

		if (!StringUtils.hasText(shopName) || !StringUtils.hasText(meals)) {// 判斷輸入內容是否為空
			return new SearchResp(SearchRtnCode.VALUE_REQUIRED.getMessage());
		}
		if (price <= 0) { // 判斷輸入金額不得小於0或等於0
			return new SearchResp(SearchRtnCode.PRICE_ERROR.getMessage());
		}
		if (mealsComment <= 0 || mealsComment > 5) {// 判斷評價星級只能在1~5星
			return new SearchResp(SearchRtnCode.COMMENT_ERROR.getMessage());
		}
		
		
		List<Search> shopNameList = searchDao.findAll();
		Set<String> oldName = new HashSet<>();
		for (Search existName : shopNameList) {
			oldName.add(existName.getShopName());
		}
		if (!oldName.contains(shopName)) {
			return new SearchResp(SearchRtnCode.STORE_NOT_EXISTED.getMessage());
		}

		List<Shop> oldStoreList = shopDao.findByShopName(shopName);
		for (Shop oldStoreName : oldStoreList) {
			if (oldStoreName.getMeals().equalsIgnoreCase(meals)) {
				return new SearchResp(SearchRtnCode.MEALS_EXISTED.getMessage());
			}
		}

		Shop shop = new Shop(shopName, meals, price, mealsComment);
		shopDao.save(shop);

		int total = 0;
		int count = 0;
		List<Shop> newStoreList = shopDao.findByShopName(shopName);
		for (Shop commentItem : newStoreList) {
			total += commentItem.getMealsComment();
			count++;
		}

		double shopComment = total / count;
		shopComment = Math.round(shopComment * 10.0) / 10.0;

		Optional<Search> commentOp = searchDao.findById(shopName);
		Search search = commentOp.get();
		search.setShopComment(shopComment);
		searchDao.save(search);
		return new SearchResp(shop, SearchRtnCode.CREATE_SUCCESSFUL.getMessage());
	}

	/* 用城市找出所有店家，限制筆數 */
	@Override
	public SearchResp getShopByCity(String city, int record) {

		if (!StringUtils.hasText(city) || record < 0) {// 判斷輸入內容是否為空
			return new SearchResp(SearchRtnCode.VALUE_REQUIRED.getMessage());
		}

		List<Search> cityList = searchDao.findByCity(city);
		if (CollectionUtils.isEmpty(cityList)) {
			return new SearchResp(SearchRtnCode.DATA_NOT_FOUND.getMessage());
		}

		// 若查詢限制的數量為0或是大於等於資料，設要印出的結果為全部
		if (record == 0 || record >= cityList.size()) {
			record = cityList.size();
		}

		// .subList(0, record)，將查詢的資料限制在XX筆之間-->(Search)
		List<Search> cityLimitList = cityList.subList(0, record);// tainan的2家店家的所有資料(AAA,BBB)
		List<String> getShopNameList = new ArrayList<>();
		for (Search shopName : cityLimitList) {
			getShopNameList.add(shopName.getShopName());// getShopNameList-->(AAA,BBB)
		}
		
		// 已符合規範的店家們，去得到店家的所有資訊
		List<Shop> getAllShopDataList = shopDao.findAllByShopNameIn(getShopNameList);// AAA,BBB
		return new SearchResp(record, getAllShopDataList, SearchRtnCode.DATA_IS_FOUND.getMessage());
	}
}
