package com.example.demo_foodMap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_foodMap.entity.Search;

@Repository
public interface SearchDao extends JpaRepository<Search, String> {

	List<Search> findByCity(String city);
}
