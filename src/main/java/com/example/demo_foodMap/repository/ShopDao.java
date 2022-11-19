package com.example.demo_foodMap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_foodMap.entity.Shop;
import com.example.demo_foodMap.entity.ShopMealsId;

@Repository
public interface ShopDao extends JpaRepository<Shop, ShopMealsId> {

	List<Shop> findByShopName(String shopName);
	
	List<Shop> findAllByShopNameIn(List<String> shopNameList);
}
